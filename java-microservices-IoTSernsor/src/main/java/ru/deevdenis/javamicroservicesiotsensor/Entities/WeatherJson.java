package ru.deevdenis.javamicroservicesiotsensor.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherJson {
    private Double latitude;
    private Double longitude;
    private Double generationtime_ms;
    private Integer utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private Double elevation;
    private Weather current_weather;
}
