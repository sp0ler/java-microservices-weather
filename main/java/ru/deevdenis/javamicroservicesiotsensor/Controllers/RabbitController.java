package ru.deevdenis.javamicroservicesiotsensor.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.deevdenis.javamicroservicesiotsensor.Entities.WeatherJson;
import ru.deevdenis.javamicroservicesiotsensor.Services.RabbitSenderService;

@RestController
public class RabbitController {

    private static final String SAVE = "/save";

    @Autowired
    private RabbitSenderService sender;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestBody WeatherJson message) {
        sender.sendMessage(message);
        return ResponseEntity.ok("Success emit to queue");
    }

}
