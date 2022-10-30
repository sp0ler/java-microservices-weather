package ru.deevdenis.javamicroservicesweather.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deevdenis.javamicroservicesweather.Entities.Weather;

@Repository
public interface WeatherDTO extends JpaRepository<Weather, Long> {
}
