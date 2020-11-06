package dev.andrevv.weather.api.client.openweather;

public interface OpenWeatherClient {
    OpenWeatherResponse getWeather(String city);
    OpenWeatherForecast getForecast(String city);
}
