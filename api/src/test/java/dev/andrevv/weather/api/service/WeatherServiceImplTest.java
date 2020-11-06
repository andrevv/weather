package dev.andrevv.weather.api.service;

import dev.andrevv.weather.api.client.openweather.OpenWeatherClient;
import dev.andrevv.weather.api.client.openweather.OpenWeatherForecast;
import dev.andrevv.weather.api.client.openweather.OpenWeatherForecastItem;
import dev.andrevv.weather.api.client.openweather.OpenWeatherWeather;
import dev.andrevv.weather.api.entity.Forecast;
import dev.andrevv.weather.api.entity.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.BDDMockito.given;

class WeatherServiceImplTest {

    @Mock
    private OpenWeatherClient openWeatherClient;

    @Mock
    private TemperatureConverter temperatureConverter;

    private WeatherService sut;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new WeatherServiceImpl(openWeatherClient, temperatureConverter);
    }

    @Test
    void getWeather() {
        // given
        String city = "moscow";
        double celsius = 20.0;
        double fahrenheit = 68.0;
        OpenWeatherWeather response = new OpenWeatherWeather(city, celsius);
        given(openWeatherClient.getWeather(city)).willReturn(response);
        given(temperatureConverter.toFahrenheit(celsius)).willReturn(fahrenheit);

        // when
        Weather weather = sut.getWeather(city);

        // then
        assertThat(weather.getCity()).isEqualTo(city);
        assertThat(weather.getTemperature().getCelsius()).isEqualTo((long)celsius);
        assertThat(weather.getTemperature().getFahrenheit()).isEqualTo((long)fahrenheit);
    }

    @Test
    void getForecast() {
        // given
        String city = "moscow";
        Instant now = Instant.now();
        List<OpenWeatherForecastItem> items = List.of(
                new OpenWeatherForecastItem(
                        Date.from(now.plusSeconds(10)),
                        1.25,
                        "cloudy"),
                new OpenWeatherForecastItem(
                        Date.from(now.plusSeconds(20)),
                        2.25,
                        "rainy"),
                new OpenWeatherForecastItem(
                        Date.from(now.plusSeconds(30)),
                        3.25,
                        "clear")
        );
        OpenWeatherForecast response = new OpenWeatherForecast(city, items);
        given(openWeatherClient.getForecast(city)).willReturn(response);

        // when
        Forecast forecast = sut.getForecast(city);

        // then
        assertThat(forecast.getCity()).isEqualTo(city);
        assertThat(forecast.getWeather()).hasSize(3);
        assertThat(forecast.getWeather())
                .extracting("date", "temperature", "description")
                .contains(
                        tuple(Date.from(now.plusSeconds(10)), 1.25, "cloudy"),
                        tuple(Date.from(now.plusSeconds(20)), 2.25, "rainy"),
                        tuple(Date.from(now.plusSeconds(30)), 3.25, "clear"));
    }
}