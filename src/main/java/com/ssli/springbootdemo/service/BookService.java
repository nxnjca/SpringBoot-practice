package com.ssli.springbootdemo.service;


import com.ssli.springbootdemo.dto.BookQueryDTO;
import com.ssli.springbootdemo.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);

    List<Book> listBooks(BookQueryDTO dto);
}
