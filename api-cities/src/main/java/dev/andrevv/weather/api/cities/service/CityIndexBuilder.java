package dev.andrevv.weather.api.cities.service;

import dev.andrevv.weather.api.cities.entity.City;

import java.util.List;
import java.util.Map;

public interface CityIndexBuilder {
    Map<String, List<City>> build();
}
