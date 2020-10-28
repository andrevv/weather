package dev.andrevv.weather.api.controller;

import dev.andrevv.weather.api.client.openweathermap.OpenWeatherClient;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import dev.andrevv.weather.api.service.TemperatureConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final OpenWeatherClient openWeatherClient;
    private final TemperatureConverter temperatureConverter;

    public WeatherController(OpenWeatherClient openWeatherClient, TemperatureConverter temperatureConverter) {
        this.openWeatherClient = openWeatherClient;
        this.temperatureConverter = temperatureConverter;
    }

    @GetMapping("/cities/{city}")
    public Weather getForCity(@PathVariable String city) {
        var response = openWeatherClient.getWeather(city);
        var celsius = response.getMain().getTemperature();
        return new Weather(city, new Temperature(celsius, temperatureConverter.toFahrenheit(celsius)));
    }
}
