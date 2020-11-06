package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherWeather {

    @JsonProperty("name")
    private String city;

    private double temperature;

    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        this.temperature = (double) main.get("temp");
    }
}
