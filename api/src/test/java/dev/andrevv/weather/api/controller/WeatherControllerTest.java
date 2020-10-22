package dev.andrevv.weather.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
@AutoConfigureJsonTesters
class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<Weather> json;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(json, new ObjectMapper());
    }

    @Test
    @SneakyThrows
    void get() {

        Weather weather = new Weather("berlin",
                new Temperature(20, 68));

        mvc.perform(MockMvcRequestBuilders.get("/api/weather/cities/berlin"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(json.write(weather).getJson()));
    }
}