package dev.andrevv.weather.api.cities.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andrevv.weather.api.cities.entity.City;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonFileCityReader implements CityReader {

    private final Path path;

    public JsonFileCityReader(Path path) {
        this.path = path;
    }

    @SneakyThrows
    @Override
    public List<City> read() {
        var json = new String(Files.readAllBytes(path));
        City[] cities = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .readValue(json, City[].class);

        return List.of(cities);
    }
}
