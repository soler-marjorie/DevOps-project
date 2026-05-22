package fr.nirahtech.devopsdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DevopsDemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DevopsDemoApplication.class);

	public static void main(String[] args) {
		final String loggerLevel = System.getenv("LOGGER_LEVEL");
		LOGGER.info(loggerLevel);
		SpringApplication.run(DevopsDemoApplication.class, args);
	}

}
