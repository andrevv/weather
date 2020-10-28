package dev.andrevv.weather.api.controller;

import dev.andrevv.weather.api.entity.Weather;
import dev.andrevv.weather.api.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@Slf4j
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/cities/{city}", produces = "application/json")
    public Weather getForCity(@PathVariable String city) {
        log.info("Got a request for '{}'.", city);
        return weatherService.getWeather(city);
    }
}
