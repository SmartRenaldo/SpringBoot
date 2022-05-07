package com.awesome;

import com.awesome.domain.Book;
import com.awesome.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    public void testSaveBook() {
        Book book = new Book(null, "--", "-----", "======");
        bookService.save(book);
    }
}
