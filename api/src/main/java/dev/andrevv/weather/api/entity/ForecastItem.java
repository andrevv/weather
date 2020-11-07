package dev.andrevv.weather.api.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ForecastItem {
    private final LocalDateTime date;
    private final double temperature;
}
