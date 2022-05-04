package com.awesome.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST model
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        String s = "springboot running get......";
        System.out.println(s);

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        return s;
    }

    @PostMapping
    public String postById() {
        String s = "springboot running post......";
        System.out.println(s);

        return s;
    }
}
