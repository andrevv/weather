package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OpenWeatherForecastItem {

    @JsonProperty("dt")
    @JsonDeserialize(converter = OpenWeatherDateConverter.class)
    private Date date;

    private double temperature;
    private String description;

    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        this.temperature = (double) main.get("temp");
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, Object>> weather) {
        this.description = (String) weather.get(0).get("description");
    }

    static class OpenWeatherDateConverter extends StdConverter<Long, Date> {

        @Override
        public Date convert(Long value) {
            return Date.from(Instant.ofEpochSecond(value));
        }
    }
}
