package com.awesome;

import com.awesome.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot17MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book(2, "boot", "boot", "boot");

        mongoTemplate.save(book);
    }

    @Test
    void testFind() {
        List<Book> books = mongoTemplate.findAll(Book.class);
        System.out.println(books);
    }

}
