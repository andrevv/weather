package dev.andrevv.weatherapicities.service;

import dev.andrevv.weatherapicities.entity.City;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.BDDMockito.given;

class CityIndexBuilderImplTest {

    private CityIndexBuilderImpl sut;

    private AutoCloseable mocks;

    @Mock
    private CityReader cityReader;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);

        sut = new CityIndexBuilderImpl(cityReader);
    }

    @AfterEach
    @SneakyThrows
    void tearDown() {
        mocks.close();
    }

    @Test
    void build() {
        // given
        List<City> cities = List.of(
                new City(1L, "Berlin", "DE"),
                new City(2L, "Bergen", "DE"),
                new City(3L, "London", "UK")
        );
        given(cityReader.read()).willReturn(cities);

        // when
        var index = sut.build();

        // then
        assertThat(index.get("ber")).hasSize(2);
        assertThat(index.get("ber"))
                .extracting("id", "name", "country")
                .contains(
                        tuple(1L, "Berlin", "DE"),
                        tuple(2L, "Bergen", "DE")
                );
        assertThat(index.get("london")).hasSize(1);
        assertThat(index.get("london"))
                .extracting("id", "name", "country")
                .contains(
                        tuple(3L, "London", "UK")
                );
    }
}