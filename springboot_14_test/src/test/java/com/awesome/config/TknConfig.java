package com.awesome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TknConfig {

    @Bean
    public String tkn() {
        return "bean tkn";
    }

}
