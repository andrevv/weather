package dev.andrevv.weather.api.cities.controller;

import dev.andrevv.weather.api.cities.entity.City;
import dev.andrevv.weather.api.cities.service.CitySearcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@Slf4j
public class CityController {

    private final CitySearcher searcher;

    public CityController(CitySearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/search")
    public List<City> cities(@RequestParam("token") String token) {
        log.info("Got a request for '{}'.", token);
        return searcher.search(token);
    }
}
