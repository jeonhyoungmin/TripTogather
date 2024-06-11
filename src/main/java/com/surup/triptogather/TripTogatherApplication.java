package com.surup.triptogather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TripTogatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripTogatherApplication.class, args);
    }

}
