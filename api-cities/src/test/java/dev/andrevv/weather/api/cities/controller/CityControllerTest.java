package dev.andrevv.weather.api.cities.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andrevv.weather.api.cities.entity.City;
import dev.andrevv.weather.api.cities.service.CitySearcher;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
class CityControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CitySearcher citySearcher;

    JacksonTester<List<City>> cityJson;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, mapper);
    }

    @Test
    @SneakyThrows
    void cities() {
        // given
        final String token = "ber";
        final List<City> cities = List.of(
                new City(1, "berlin", "DE"),
                new City(2, "bergen", "DE")
        );
        given(citySearcher.search(token)).willReturn(cities);

        // when
        // then
        mvc.perform(MockMvcRequestBuilders.get("/api/cities/search?token=ber"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(cityJson.write(cities).getJson()));
    }
}