package dev.andrevv.weather.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    private JacksonTester<Weather> weatherJson;
    private JacksonTester<Forecast> forecastJson;

    @MockBean
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(
                this,
                new ObjectMapper()
                        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS));
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
        Instant now = Instant.now();
        Forecast forecast = new Forecast(
                city,
                List.of(
                        new ForecastItem(
                                Date.from(now.plusSeconds(10)),
                                1.25,
                                "cloudy"),
                        new ForecastItem(
                                Date.from(now.plusSeconds(20)),
                                2.25,
                                "rainy"),
                        new ForecastItem(
                                Date.from(now.plusSeconds(10)),
                                3.25,
                                "clear")
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