package de.htwberlin.informationssicherheit.sqlinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Group2Application {

	public static void main(String[] args) {
		SpringApplication.run(Group2Application.class, args);
	}

}
