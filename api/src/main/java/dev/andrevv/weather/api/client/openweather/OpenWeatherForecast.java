package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OpenWeatherForecast {

    private String city;

    @JsonProperty("list")
    @JsonDeserialize(contentAs = OpenWeatherForecastItem.class)
    private List<OpenWeatherForecastItem> weather;

    @JsonProperty("city")
    private void unpackCity(Map<String, Object> city) {
        this.city = (String) city.get("name");
    }
}
