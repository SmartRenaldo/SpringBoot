package com.awesome.controller;

import com.awesome.controller.utils.R;
import com.awesome.domain.Book;
import com.awesome.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
// realise interaction between front-end and back-end
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if ("123".equals(book.getName())) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "Added successfully!" : "Add failed!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new R(flag, flag ? "Updated successfully!" : "Update failed!");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = bookService.delete(id);
        return new R(flag, flag ? "Deleted successfully!" : "Data synchronization failed. Auto Refresh!");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

}
