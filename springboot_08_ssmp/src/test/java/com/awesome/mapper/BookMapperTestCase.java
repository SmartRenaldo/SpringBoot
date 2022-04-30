package com.awesome.mapper;

import com.awesome.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookMapperTestCase {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelectById() {
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("Colouring Books for Adults");
        book.setName("Floating World Japanese");
        book.setDescription("Featuring elegant");
        bookMapper.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setType("testing...");
        book.setName("testing......");
        book.setDescription("testing...///");
        bookMapper.updateById(book);
    }

    @Test
    void testDelete() {
        bookMapper.deleteById(13);
    }

    @Test
    void testSelectAll() {
        List<Book> books = bookMapper.selectList(null);

        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void testSelectPage() {
        IPage page = new Page(1, 5);
        bookMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testSelectBy() {
        String s = "";

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // Strings.isNotEmpty(s) === s != null && s != ""
        lqw.like(s != null && s != "", Book::getName, s);
        bookMapper.selectList(lqw);
    }
}
