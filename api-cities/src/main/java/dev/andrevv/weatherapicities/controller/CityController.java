package dev.andrevv.weatherapicities.controller;

import dev.andrevv.weatherapicities.entity.City;
import dev.andrevv.weatherapicities.service.CitySearcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CitySearcher searcher;

    public CityController(CitySearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/search/{token}")
    public List<City> cities(@PathVariable String token) {
        return searcher.search(token);
    }
}
