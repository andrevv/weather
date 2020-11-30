package dev.andrevv.weather.api.cities.service;

import dev.andrevv.weather.api.cities.entity.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityIndexBuilderImpl implements CityIndexBuilder {

    private final CityReader cityReader;

    public CityIndexBuilderImpl(CityReader cityReader) {
        this.cityReader = cityReader;
    }

    @Override
    public Map<String, List<City>> build() {
        return buildIndex(cityReader.read());
    }

    private Map<String, List<City>> buildIndex(List<City> cities) {
        Map<String, List<City>> index = new HashMap<>();

        for (City city : cities) {
            for (var token : tokenize(city.getName())) {
                var list = index.putIfAbsent(token, new ArrayList<>());
                if (list == null) {
                    list = index.get(token);
                }

                list.add(city);
            }
        }

        return index;
    }

    private String[] tokenize(String s) {
        String[] tokens = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            tokens[i] = s.substring(0, i + 1).toLowerCase();
        }

        return tokens;
    }
}
