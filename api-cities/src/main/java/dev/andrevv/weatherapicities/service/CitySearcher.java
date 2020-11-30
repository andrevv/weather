package dev.andrevv.weatherapicities.service;

import dev.andrevv.weatherapicities.entity.City;

import java.util.List;

public interface CitySearcher {
    List<City> search(String token);
}
