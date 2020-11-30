package dev.andrevv.weatherapicities.config;

import dev.andrevv.weatherapicities.service.CityReader;
import dev.andrevv.weatherapicities.service.JsonFileCityReader;
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
