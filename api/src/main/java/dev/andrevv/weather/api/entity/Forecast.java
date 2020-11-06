package dev.andrevv.weather.api.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Forecast {
    private final String city;
    private final List<ForecastItem> weather;
}
