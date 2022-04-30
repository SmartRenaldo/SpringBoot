package com.awesome.service;

import com.awesome.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface BookServiceOrigin {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean deleteById(Integer id);
    Book queryById(Integer id);
    List<Book> queryAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
