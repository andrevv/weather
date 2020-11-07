package dev.andrevv.weather.api.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ForecastItem {
    private final LocalDate date;
    private final double temperature;
}
