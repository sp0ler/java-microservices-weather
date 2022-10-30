package ru.deevdenis.javamicroservicesiotsensor.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.deevdenis.javamicroservicesiotsensor.Configurations.RabbitConfiguration;
import ru.deevdenis.javamicroservicesiotsensor.Entities.Weather;
import ru.deevdenis.javamicroservicesiotsensor.Entities.WeatherJson;
import ru.deevdenis.javamicroservicesiotsensor.Models.GEOFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@EnableRabbit
@Component
public class RabbitSenderService {

    private String urlString;
    private URL url;

    @Autowired
    private Environment env;

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private GEOFactory geoFactory;

    @PostConstruct
    public void init() {
        try {
            urlString = Objects.requireNonNull(env.getProperty("url"));
            url = new URL(urlString);
        } catch (NullPointerException e) {
            log.error("Url is null.");
            urlString = null;
        } catch (MalformedURLException e) {
            log.error("Cannot connect to url.");
        }
    }

    public void sendMessage(WeatherJson message) {
        Weather weather = message.getCurrent_weather();
        weather.setCity(
                geoFactory.findCityByCords(message.getLatitude(), message.getLongitude())
        );
        weather.setTime(Instant.now().toString());
        message.setCurrent_weather(weather);

        template.convertAndSend(
                RabbitConfiguration.TOPIC_EXCHANGE_NAME,
                RabbitConfiguration.ROUTING_KEY,
                message
        );

        log.info("Sended to queue1: {}", message);
    }

    @Scheduled(fixedDelay = 60000)
    public void sendMessage() throws IOException {

        if (urlString != null) {
            ObjectMapper mapper = new ObjectMapper();
            WeatherJson message = mapper.readValue(url, WeatherJson.class);

            this.sendMessage(message);
        } else {
            log.error("Url is null.");
        }

        //mvn spring-boot:run -Dspring-boot.run.arguments="--url=https://api.open-meteo.com/v1/forecast?latitude=48.2092&longitude=16.3728&current_weather=true"
        //java -jar java-microservices-weather-0.0.1-SNAPSHOT.jar --url="https://api.open-meteo.com/v1/forecast?latitude=48.2092&longitude=16.3728&current_weather=true" --server.port=8082
    }
}
