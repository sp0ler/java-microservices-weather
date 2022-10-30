package ru.deevdenis.javamicroservicesiotsensor.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private Long id;
    private String city;
    private Float temperature;
    private Float windspeed;
    private Float winddirection;
    private Integer weathercode;
    private String time;
}
