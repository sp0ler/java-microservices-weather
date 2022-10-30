package ru.deevdenis.javamicroservicesweather.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.deevdenis.javamicroservicesweather.Repositories.WeatherDTO;
import ru.deevdenis.javamicroservicesweather.Entities.Weather;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Component
@Transactional
public class WeatherService {
    @Autowired
    private WeatherDTO weatherDTO;

    public void save(Weather weather) {
        weatherDTO.save(weather);
        log.info("Saved to DB: {}", weather);
    }

    public List<Weather> findAll() {
        return weatherDTO.findAll();
    }
}
