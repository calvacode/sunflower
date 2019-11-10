package com.zoohackathon.sunflower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties
public class SunflowerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunflowerApplication.class, args);
    }
}
