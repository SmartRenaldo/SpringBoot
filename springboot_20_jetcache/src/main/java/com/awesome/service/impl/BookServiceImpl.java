package com.awesome.service.impl;

import com.alicp.jetcache.anno.*;
import com.awesome.domain.Book;
import com.awesome.mapper.BookMapper;
import com.awesome.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600, cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }
}
