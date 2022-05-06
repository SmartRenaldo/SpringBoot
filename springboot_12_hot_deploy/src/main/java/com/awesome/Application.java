package com.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    /*
     * devtools:
     *     restart:
     *       additional-exclude: static/**,public/**,config/**
     *       enabled: false
     */

    public static void main(String[] args) {
        // higher priority than config file
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class);
    }

}
