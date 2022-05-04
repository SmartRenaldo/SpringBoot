package com.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {
        String[] arg = new String[1];
        arg[0] = "--server.port=8082";
        //close the entry of external configuration
        SpringApplication.run(SSMPApplication.class);
        //SpringApplication.run(SSMPApplication.class, arg);
    }

}
