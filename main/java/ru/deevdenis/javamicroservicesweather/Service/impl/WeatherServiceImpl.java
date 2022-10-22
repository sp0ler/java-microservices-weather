package ru.deevdenis.javamicroservicesweather.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.deevdenis.javamicroservicesweather.Repository.WeatherDTO;
import ru.deevdenis.javamicroservicesweather.Repository.entity.Weather;
import ru.deevdenis.javamicroservicesweather.Service.WeatherService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDTO weatherDTO;

    @Override
    @Transactional
    public void save(Weather weather) {
        weatherDTO.save(weather);
    }

    @Override
    @Transactional
    public List<Weather> findAll() {
        return weatherDTO.findAll();
    }
}
