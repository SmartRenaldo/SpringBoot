package com.awesome.controller;

import com.awesome.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("getById running...");

        return "getById running...";
    }

    @GetMapping("/books")
    public Book get() {
        System.out.println("getById running...");

        return new Book(1, "Sheldon", "Sheldon", "Leonard");
    }

}
