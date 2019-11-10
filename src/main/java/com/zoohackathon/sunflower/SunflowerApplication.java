package com.zoohackathon.sunflower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SunflowerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunflowerApplication.class, args);
	}

}
