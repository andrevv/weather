package dev.andrevv.weather.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andrevv.weather.api.entity.Forecast;
import dev.andrevv.weather.api.entity.ForecastItem;
import dev.andrevv.weather.api.entity.Temperature;
import dev.andrevv.weather.api.entity.Weather;
import dev.andrevv.weather.api.service.WeatherService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private JacksonTester<Weather> weatherJson;
    private JacksonTester<Forecast> forecastJson;

    @MockBean
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, mapper);
    }

    @Test
    @SneakyThrows
    void getWeather() {

        // given
        String city = "berlin";
        Weather weather = new Weather(city, new Temperature(20, 68));
        given(weatherService.getWeather(city)).willReturn(weather);

        // when
        // then
        mvc.perform(MockMvcRequestBuilders.get("/api/weather/cities/berlin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(weatherJson.write(weather).getJson()));
    }

    @Test
    @SneakyThrows
    void getForecast() {

        // given
        String city = "vienna";
        LocalDate now = LocalDate.now(ZoneOffset.UTC);
        Forecast forecast = new Forecast(
                city,
                List.of(
                        new ForecastItem(
                                now.plusDays(1),
                                1),
                        new ForecastItem(
                                now.plusDays(2),
                                2),
                        new ForecastItem(
                                now.plusDays(3),
                                3)
                ));
        given(weatherService.getForecast(city)).willReturn(forecast);

        // when
        // then
        mvc.perform(MockMvcRequestBuilders.get("/api/weather/cities/vienna/forecast"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(forecastJson.write(forecast).getJson()));
    }
}