package com.ssli.springbootdemo.service.impl;


import com.ssli.springbootdemo.entity.Book;
import com.ssli.springbootdemo.exception.BusinessException;
import com.ssli.springbootdemo.mapper.BookMapper;
import com.ssli.springbootdemo.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    @Override
    public Book getBookById(Long id) {
        Book book = bookMapper.selectById(id);
        if(book == null) {
            throw new BusinessException(4004,"book not found");
        }
        return book;
    }

    @Override
    public Book createBook(Book book) {
        Book existingBook = bookMapper.selectByName(book.getName());
        if(existingBook != null) {
            throw new BusinessException(4001,"book already exists");
        }
        int row = bookMapper.insert(book);
        if(row != 1){
            throw new BusinessException(5001, "图书创建失败");
        }
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookMapper.selectById(book.getId());
        if (existingBook == null) {
            throw new BusinessException(4004, "图书不存在");
        }

        if (!existingBook.getName().equals(book.getName())) {
            Book duplicateBook = bookMapper.selectByName(book.getName());
            if (duplicateBook != null) {
                throw new BusinessException(4001, "图书名称已存在");
            }
        }
        int rows = bookMapper.updateById(book);
        if (rows != 1) {
            throw new BusinessException(5002, "图书修改失败");
        }

        return bookMapper.selectById(book.getId());
    }

    @Override
    public void deleteBookById(Long id) {
        Book existingBook = bookMapper.selectById(id);
        if (existingBook == null) {
            throw new BusinessException(4004, "图书不存在");
        }
        int rows = bookMapper.deleteById(id);
        if (rows != 1) {
            throw new BusinessException(5003, "图书删除失败");
        }
    }
}
