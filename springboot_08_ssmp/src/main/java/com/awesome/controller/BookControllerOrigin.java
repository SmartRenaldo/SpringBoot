package com.awesome.controller;

import com.awesome.domain.Book;
import com.awesome.service.IBookService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookControllerOrigin {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return bookService.getPage(currentPage, pageSize);
    }

}
