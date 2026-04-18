package com.ssli.springbootdemo.service.impl;

import com.ssli.springbootdemo.entity.Book;
import com.ssli.springbootdemo.exception.BusinessException;
import com.ssli.springbootdemo.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book getBookById(Long id) {
        return new Book(id,"book-",20.0);
    }

    @Override
    public Book createBook(Book book) {
        if("java核心技术".equals(book.getName())){
            throw new BusinessException(4001,"图书名称已存在");
        }
        return book;
    }
}
