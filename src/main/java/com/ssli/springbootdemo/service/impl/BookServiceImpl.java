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
        if(book.getName()==null || book.getName().isBlank()){
            throw new BusinessException(400,"book name is null");
        }
        return book;
    }
}
