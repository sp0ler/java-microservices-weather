package ru.deevdenis.javamicroservicesweather.Service;

import ru.deevdenis.javamicroservicesweather.Repository.entity.Weather;

import java.util.List;

public interface WeatherService {
    void save(Weather weather);

    List<Weather> findAll();
}
