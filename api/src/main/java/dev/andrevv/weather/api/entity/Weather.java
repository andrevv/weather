package dev.andrevv.weather.api.entity;

import lombok.Data;

@Data
public class Weather {
    private final String city;
    private final String description;
    private final Temperature temperature;
}
