package com.tokyoprogrammer.aqitracer;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class AqitracerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AqitracerApplication.class, args);
    }
}
