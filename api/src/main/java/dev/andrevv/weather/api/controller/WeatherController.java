package dev.andrevv.weather.api.controller;

import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @GetMapping("/cities/{city}")
    public Weather getForCity(@PathVariable String city) {
        return new Weather(city, new Temperature(20, 68));
    }
}
