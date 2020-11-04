package dev.andrevv.weather.api.service;

import dev.andrevv.weather.api.client.openweather.OpenWeatherClient;
import dev.andrevv.weather.api.client.openweather.OpenWeatherMain;
import dev.andrevv.weather.api.client.openweather.OpenWeatherResponse;
import dev.andrevv.weather.api.entity.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
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
        OpenWeatherResponse response = new OpenWeatherResponse(city, new OpenWeatherMain(celsius));
        given(openWeatherClient.getWeather(city)).willReturn(response);
        given(temperatureConverter.toFahrenheit(celsius)).willReturn(fahrenheit);

        // when
        Weather weather = sut.getWeather(city);

        // then
        assertThat(weather.getCity()).isEqualTo(city);
        assertThat(weather.getTemperature().getCelsius()).isEqualTo((long)celsius);
        assertThat(weather.getTemperature().getFahrenheit()).isEqualTo((long)fahrenheit);
    }
}