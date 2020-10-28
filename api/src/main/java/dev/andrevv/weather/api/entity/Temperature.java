package dev.andrevv.weather.api.entity;

import lombok.Data;

@Data
public class Temperature {
    private final long celsius;
    private final long fahrenheit;
}
