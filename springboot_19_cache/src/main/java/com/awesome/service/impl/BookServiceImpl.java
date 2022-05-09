package com.awesome.service.impl;

import com.awesome.domain.Book;
import com.awesome.mapper.BookMapper;
import com.awesome.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

//    private HashMap<Integer, Book> cache = new HashMap<>();

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

//    @Override
//    public Book getById(Integer id) {
//        Book book = cache.get(id);
//        if (book == null) {
//            Book queriedBook = bookMapper.selectById(id);
//            cache.put(id, queriedBook);
//            return queriedBook;
//        }
//        return cache.get(id);
//    }
}
