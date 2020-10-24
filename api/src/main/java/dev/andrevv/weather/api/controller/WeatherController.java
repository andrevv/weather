package dev.andrevv.weather.api.controller;

import dev.andrevv.weather.api.client.openweathermap.OpenWeatherClient;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final OpenWeatherClient client;

    public WeatherController(OpenWeatherClient client) {
        this.client = client;
    }

    @GetMapping("/cities/{city}")
    public Weather getForCity(@PathVariable String city) {

        var r = client.getWeather(city);

        return new Weather(city, new Temperature(r.getMain().getTemp(), 68));
    }
}
