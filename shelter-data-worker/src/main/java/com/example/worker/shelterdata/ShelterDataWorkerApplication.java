package com.example.worker.shelterdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.worker.shelterdata", "com.example.core"})
public class ShelterDataWorkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShelterDataWorkerApplication.class, args);
    }
}
