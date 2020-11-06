package dev.andrevv.weather.api.client.openweather;

import org.springframework.web.client.RestTemplate;

public class OpenWeatherClientImpl implements OpenWeatherClient {

    private final RestTemplate rest;
    private final String apiKey;

    public OpenWeatherClientImpl(RestTemplate restTemplate, String apiKey) {
        this.rest = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public OpenWeatherWeather getWeather(String city) {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);

        var r = rest.getForEntity(url, OpenWeatherWeather.class);

        return r.getBody();
    }

    @Override
    public OpenWeatherForecast getForecast(String city) {
        String url = String.format("https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", city, apiKey);

        var r = rest.getForEntity(url, OpenWeatherForecast.class);

        return r.getBody();
    }
}
