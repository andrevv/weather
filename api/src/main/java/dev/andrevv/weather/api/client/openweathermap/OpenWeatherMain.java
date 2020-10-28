package dev.andrevv.weather.api.client.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherMain {

    public OpenWeatherMain() {
        temperature = 0;
    }

    @JsonProperty("temp")
    private final double temperature;
}
