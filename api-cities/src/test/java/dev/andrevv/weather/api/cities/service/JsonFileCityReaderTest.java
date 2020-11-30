package dev.andrevv.weather.api.cities.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class JsonFileCityReaderTest {

    private JsonFileCityReader sut;

    @BeforeEach
    @SneakyThrows
    void setUp() {
        Path path = ResourceUtils.getFile("classpath:cities.json").toPath();
        sut = new JsonFileCityReader(path);
    }

    @Test
    void read() {
        // given
        // when
        var cities = sut.read();

        // then
        assertThat(cities)
                .extracting("id", "name", "country")
                .contains(
                        tuple(1L, "London", "England"),
                        tuple(2L, "Berlin", "Germany"),
                        tuple(3L, "Moscow", "Russia")
                );
    }
}