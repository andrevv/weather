package dev.andrevv.weather.api.client.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherForecastItem {

    @JsonProperty("dt")
    @JsonDeserialize(converter = OpenWeatherDateConverter.class)
    private LocalDateTime date;

    private double temperature;
    private String description;

    @JsonProperty("main")
    private void unpackMain(Map<String, Object> main) {
        this.temperature = Double.parseDouble(main.get("temp").toString());
    }

    @JsonProperty("weather")
    private void unpackWeather(List<Map<String, Object>> weather) {
        this.description = (String) weather.get(0).get("description");
    }

    static class OpenWeatherDateConverter extends StdConverter<Long, LocalDateTime> {

        @Override
        public LocalDateTime convert(Long value) {
            return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC);
        }
    }
}
