package dev.andrevv.weatherapicities.service;

import dev.andrevv.weatherapicities.entity.City;

import java.util.List;
import java.util.Map;

public interface CityIndexBuilder {
    Map<String, List<City>> build();
}
