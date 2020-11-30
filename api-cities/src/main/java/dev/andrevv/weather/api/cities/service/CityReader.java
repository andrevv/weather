package dev.andrevv.weather.api.cities.service;

import dev.andrevv.weather.api.cities.entity.City;

import java.util.List;

public interface CityReader {
    List<City> read();
}
