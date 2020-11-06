package dev.andrevv.weather.api.entity;

import lombok.Data;

import java.util.List;

@Data
public class Forecast {
    private final String city;
    private final List<ForecastItem> forecasts;
}
