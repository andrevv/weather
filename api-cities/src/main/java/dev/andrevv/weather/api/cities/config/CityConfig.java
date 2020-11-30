package dev.andrevv.weather.api.cities.config;

import dev.andrevv.weather.api.cities.service.CityReader;
import dev.andrevv.weather.api.cities.service.JsonFileCityReader;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class CityConfig {
    @Bean
    @SneakyThrows
    public CityReader cityReader() {
        var path = ResourceUtils.getFile("classpath:cities.json").toPath();
        return new JsonFileCityReader(path);
    }
}
