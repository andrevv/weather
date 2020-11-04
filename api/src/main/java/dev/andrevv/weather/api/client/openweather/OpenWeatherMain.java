package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OpenWeatherMain {

    public OpenWeatherMain() {
        temperature = 0;
    }

    @JsonProperty("temp")
    private final double temperature;
}
