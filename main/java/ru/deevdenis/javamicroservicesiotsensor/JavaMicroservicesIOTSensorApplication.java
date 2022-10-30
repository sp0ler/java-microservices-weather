package ru.deevdenis.javamicroservicesiotsensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaMicroservicesIOTSensorApplication {

	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println("ARG:" + arg);
		}

		SpringApplication.run(JavaMicroservicesIOTSensorApplication.class, args);
	}


}
