package ru.deevdenis.javamicroservicesweather.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.deevdenis.javamicroservicesweather.Repository.entity.Weather;

@Repository
public interface WeatherDTO extends JpaRepository<Weather, Long> {
}
