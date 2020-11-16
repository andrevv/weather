package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherWeather {

    @JsonProperty("name")
    private String city;

    @JsonIgnore
    private String description;

    @JsonIgnore
    private double temperature;

    @JsonProperty("dt")
    private long time;

    @JsonProperty("timezone")
    private int timezone;

    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        this.temperature = (double) main.get("temp");
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, Object>> weather) {
        this.description = (String) weather.get(0).get("main");
    }
}
