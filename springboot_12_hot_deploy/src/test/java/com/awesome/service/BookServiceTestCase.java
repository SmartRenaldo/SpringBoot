package com.awesome.service;

import com.awesome.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testQueryById() {
        System.out.println(bookService.getById(1));
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("Colouring Books for Adults");
        book.setName("Floating World Japanese");
        book.setDescription("Featuring elegant");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(14);
        book.setType("testing...");
        book.setName("testing......");
        book.setDescription("testing...///");
        bookService.updateById(book);
    }

    @Test
    void testDelete() {
        bookService.removeById(13);
    }

    @Test
    void testSelectAll() {
        List<Book> books = bookService.list();

        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
