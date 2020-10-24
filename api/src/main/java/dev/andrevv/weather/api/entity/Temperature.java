package dev.andrevv.weather.api.entity;

import lombok.Data;

@Data
public class Temperature {
    private final double celsius;
    private final double fahrenheit;
}
