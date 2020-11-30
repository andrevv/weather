package dev.andrevv.weather.api.cities.service;

import dev.andrevv.weather.api.cities.entity.City;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.BDDMockito.given;

class CitySearcherImplTest {

    private CitySearcherImpl sut;

    private AutoCloseable mocks;

    @Mock
    private CityIndexBuilder cityIndexBuilder;

    @BeforeEach
    void setUp() {
        mocks = MockitoAnnotations.openMocks(this);

        final Map<String, List<City>> index = new HashMap<>();
        index.put("ber", List.of(
                new City(1, "berlin", "DE"),
                new City(2, "bergen", "DE")
        ));

        given(cityIndexBuilder.build()).willReturn(index);

        sut = new CitySearcherImpl(cityIndexBuilder);
    }

    @AfterEach
    @SneakyThrows
    void tearDown() {
        mocks.close();
    }

    @Test
    public void search() {
        // given
        final String token = "ber";

        // when
        List<City> cities = sut.search(token);

        // then
        assertThat(cities)
                .extracting("id", "name", "country")
                .contains(
                        tuple(1L, "berlin", "DE"),
                        tuple(2L, "bergen", "DE")
                );
    }
}