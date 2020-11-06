package dev.andrevv.weather.api.client.openweather;

public interface OpenWeatherClient {
    OpenWeatherWeather getWeather(String city);
    OpenWeatherForecast getForecast(String city);
}
