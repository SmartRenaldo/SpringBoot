package com.awesome.controller;

import com.awesome.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST model
 */
@RestController
@RequestMapping("/books")
public class BookController {

    /**
     * read yalm data
     * @return
     */
    @Value("${country}")
    private String country1;

    @Value("${username.name}")
    private String name1;

    @Value("${hobbies[1]}")
    private String hobbies1;

    @Value("${users[1].age}")
    private String users1Age;

    @Value("${tmpDir}")
    private String tmpDir;


    @Value("${tmpDir2}")
    private String tmpDir2;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById() {
        String s = "springboot running get......";
        System.out.println("country1 = " + country1);
        System.out.println("name1 = " + name1);
        System.out.println("hobbies1 = " + hobbies1);
        System.out.println("users1Age = " + users1Age);
        System.out.println("tmpDir = " + tmpDir);
        System.out.println("tmpDir2 = " + tmpDir2);
        System.out.println("env.getProperty(\"user2.age\") = " + env.getProperty("user2.age"));
        System.out.println("env.getProperty(\"users[1].age\") = " + env.getProperty("users[1].age"));
        System.out.println("env.getProperty(\"users2[0].name\") = " + env.getProperty("users2[0].name"));
        System.out.println("myDataSource = " + myDataSource);
        System.out.println(s);

        return s;
    }

    @PostMapping
    public String postById() {
        String s = "springboot running post......";
        System.out.println(s);

        return s;
    }
}
