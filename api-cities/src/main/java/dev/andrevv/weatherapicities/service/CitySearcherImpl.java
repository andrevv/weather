package dev.andrevv.weatherapicities.service;

import dev.andrevv.weatherapicities.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CitySearcherImpl implements CitySearcher {

    private final Map<String, List<City>> index;

    public CitySearcherImpl(CityIndexBuilder cityIndexBuilder) {
        this.index = cityIndexBuilder.build();
    }

    @Override
    public List<City> search(String token) {
        return index.get(token);
    }
}
