package dev.andrevv.weather.api.client.openweathermap;

public interface OpenWeatherClient {
    OpenWeatherResponse getWeather(String city);
}
