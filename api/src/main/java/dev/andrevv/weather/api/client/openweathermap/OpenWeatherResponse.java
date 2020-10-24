package dev.andrevv.weather.api.client.openweathermap;

import lombok.Data;

@Data
public class OpenWeatherResponse {

    public OpenWeatherResponse() {
        this.name = null;
        this.main = null;
    }

    private final String name;
    private final OpenWeatherMain main;
}
