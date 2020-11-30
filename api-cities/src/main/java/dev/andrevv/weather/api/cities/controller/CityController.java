package dev.andrevv.weather.api.cities.controller;

import dev.andrevv.weather.api.cities.entity.City;
import dev.andrevv.weather.api.cities.service.CitySearcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CitySearcher searcher;

    public CityController(CitySearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/search")
    public List<City> cities(@RequestParam("token") String token) {
        return searcher.search(token);
    }
}
