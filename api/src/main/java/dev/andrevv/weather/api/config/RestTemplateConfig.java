package dev.andrevv.weather.api.config;

import dev.andrevv.weather.api.client.openweathermap.OpenWeatherClient;
import dev.andrevv.weather.api.client.openweathermap.OpenWeatherClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public OpenWeatherClient openWeatherClient(RestTemplate restTemplate) {
        String apiKey = System.getenv("API_KEY");
        log.info("OpenWeather API key found: {}", apiKey.replaceAll("(?<=^.{3}).*", "*****"));
        return new OpenWeatherClientImpl(restTemplate, apiKey);
    }
}
