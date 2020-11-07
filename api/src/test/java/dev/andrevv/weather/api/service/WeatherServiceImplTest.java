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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
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
        LocalDateTime now = LocalDateTime.of(LocalDate.now(ZoneOffset.UTC), LocalTime.MIDNIGHT);
        List<OpenWeatherForecastItem> items = List.of(
                new OpenWeatherForecastItem(
                        now.plusDays(1).plusHours(1),
                        1.25,
                        "cloudy"),
                new OpenWeatherForecastItem(
                        now.plusDays(1).plusHours(2),
                        2.25,
                        "rainy"),
                new OpenWeatherForecastItem(
                        now.plusDays(1).plusHours(3),
                        3.25,
                        "clear"),
                new OpenWeatherForecastItem(
                        now.plusDays(2).plusHours(1),
                        1.25,
                        "cloudy"),
                new OpenWeatherForecastItem(
                        now.plusDays(2).plusHours(2),
                        2.25,
                        "clear")
        );
        OpenWeatherForecast response = new OpenWeatherForecast(city, items);
        given(openWeatherClient.getForecast(city)).willReturn(response);

        // when
        Forecast forecast = sut.getForecast(city);

        // then
        assertThat(forecast.getCity()).isEqualTo(city);
        assertThat(forecast.getForecasts()).hasSize(2);
        assertThat(forecast.getForecasts())
                .extracting("date", "temperature")
                .contains(
                        tuple(now.plusDays(1), 2.25),
                        tuple(now.plusDays(2), 1.75));
    }
}