package ru.deevdenis.javamicroservicesweather.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.deevdenis.javamicroservicesweather.Configurations.RabbitConfiguration;
import ru.deevdenis.javamicroservicesweather.Entities.WeatherJson;

@Slf4j
@EnableRabbit
@Component
public class RabbitListenerService {
    @Autowired
    private WeatherService weatherService;

    @RabbitListener(queues = RabbitConfiguration.QUEUE_NAME)
    public void processMyQueue1(WeatherJson weatherJson) {
        log.info("Received form queue1: {}", weatherJson);
        weatherService.save(weatherJson.getCurrent_weather());
    }
}
