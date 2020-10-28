package dev.andrevv.weather.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import dev.andrevv.weather.api.service.WeatherService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    private JacksonTester<Weather> json;

    @MockBean
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    @SneakyThrows
    void get() {

        // given
        String city = "berlin";
        Weather weather = new Weather(city, new Temperature(20, 68));
        given(weatherService.getWeather(city)).willReturn(weather);

        // when
        // then
        mvc.perform(MockMvcRequestBuilders.get("/api/weather/cities/berlin"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json(json.write(weather).getJson()));
    }
}