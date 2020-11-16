package dev.andrevv.weather.api.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Weather {
    private final String city;
    private final String description;
    private final Temperature temperature;
    private final LocalDate date;
}
