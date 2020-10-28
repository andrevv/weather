package dev.andrevv.weather.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemperatureConverterImplTest {

    private TemperatureConverterImpl converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverterImpl();
    }

    @Test
    void toFahrenheit() {
        // given
        final double celsius = 20;

        // when
        double fahrenheit = converter.toFahrenheit(celsius);

        // then
        assertThat(68.0).isEqualTo(fahrenheit);
    }
}