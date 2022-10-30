package ru.deevdenis.javamicroservicesiotsensor.Models;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GEOFactory {
    private static final Map<String, String> cityMap = new HashMap<>();

    static {
        cityMap.put("48.20, 16.38", "Vienna");
    }

    public String findCityByCords(@NonNull Double latitude, @NonNull  Double longitude) {
        String formatted = String.format("%.2f, %.2f", latitude , longitude);
        return cityMap.get(formatted);
    }

}
