package dev.andrevv.weather.api.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConverterImpl implements TemperatureConverter {
    @Override
    public double toFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
}
