package dev.andrevv.weather.api.entity;

import lombok.Data;

@Data
public class Temperature {
    private final int celsius;
    private final int fahrenheit;
}
