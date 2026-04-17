package com.ssli.springbootdemo.controller;

import com.ssli.springbootdemo.common.Result;
import com.ssli.springbootdemo.entity.Book;
import com.ssli.springbootdemo.service.BookService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello book";
    }

    @PostMapping("create")
    public Result<Book> create(@RequestBody Book book) {
        Book book1 = bookService.createBook(book);
        return Result.success("创建成功",book1);
    }

    @GetMapping("query/{id}")
    public Result<Book> queryById(@PathVariable Long id) {
        Book book =  bookService.getBookById(id);
        return Result.success(book);

    }

}
