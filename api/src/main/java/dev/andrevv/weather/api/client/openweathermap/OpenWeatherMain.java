package dev.andrevv.weather.api.client.openweathermap;

import lombok.Data;

@Data
public class OpenWeatherMain {

    public OpenWeatherMain() {
        temp = 0;
    }

    private final double temp;
}
