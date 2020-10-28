package dev.andrevv.weather.api.service;

import dev.andrevv.weather.api.entity.Weather;

public interface WeatherService {
    Weather getWeather(String city);
}
