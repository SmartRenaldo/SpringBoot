package com.awesome.service;

import com.awesome.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IBookService extends IService<Book> {
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
    Book getById(Integer id);
}
