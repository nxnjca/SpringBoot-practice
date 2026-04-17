package com.ssli.springbootdemo.service;

import com.ssli.springbootdemo.entity.Book;

public interface BookService {
    Book getBookById(Long id);

    Book createBook(Book book);
}
