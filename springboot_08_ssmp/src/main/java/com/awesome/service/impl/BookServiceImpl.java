package com.awesome.service.impl;

import com.awesome.domain.Book;
import com.awesome.mapper.BookMapper;
import com.awesome.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page, null);

        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        wrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        wrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page, wrapper);

        return page;
    }
}
