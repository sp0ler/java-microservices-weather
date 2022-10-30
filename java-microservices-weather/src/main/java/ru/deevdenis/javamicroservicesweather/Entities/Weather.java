package ru.deevdenis.javamicroservicesweather.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "weather")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city", length = 20)
    private String city;

    @Column(name = "temperature")
    private Float temperature;

    @Column(name = "windspeed")
    private Float windspeed;

    @Column(name = "winddirection")
    private Float winddirection;

    @Column(name = "weathercode")
    private Integer weathercode;

    @Column(name = "time", length = 50)
    private String time;
}
