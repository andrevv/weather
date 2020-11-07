package dev.andrevv.weather.api.service;

import dev.andrevv.weather.api.client.openweather.OpenWeatherClient;
import dev.andrevv.weather.api.client.openweather.OpenWeatherForecastItem;
import dev.andrevv.weather.api.entity.Forecast;
import dev.andrevv.weather.api.entity.ForecastItem;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final OpenWeatherClient openWeatherClient;
    private final TemperatureConverter temperatureConverter;

    public WeatherServiceImpl(
            OpenWeatherClient openWeatherClient,
            TemperatureConverter temperatureConverter) {
        this.openWeatherClient = openWeatherClient;
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public Weather getWeather(String city) {
        var response = openWeatherClient.getWeather(city);
        var celsius = response.getTemperature();
        return new Weather(
                city,
                new Temperature(
                        Math.round(celsius),
                        Math.round(temperatureConverter.toFahrenheit(celsius))));
    }

    @Override
    public Forecast getForecast(String city) {
        var response = openWeatherClient.getForecast(city);

        var items = response.getForecasts()
                .stream()
                .collect(groupingBy(f -> f.getDate().toLocalDate(), Collectors.averagingDouble(OpenWeatherForecastItem::getTemperature)));

        return new Forecast(
                response.getCity(),
                items.entrySet()
                        .stream()
                        .map(item -> new ForecastItem(
                                item.getKey(),
                                Math.round(item.getValue())))
                        .collect(Collectors.toList()));
    }
}
