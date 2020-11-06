package dev.andrevv.weather.api.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class ForecastItem {
    private final Date date;
    private final double temperature;
    private final String description;
}
