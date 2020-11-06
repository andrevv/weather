package dev.andrevv.weather.api.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ForecastItem {
    private final Date date;
    private final double temperature;
    private final String description;
}
