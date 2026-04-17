package com.ssli.springbootdemo.controller;

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

    @GetMapping("/info")
    public String info(@RequestParam String name,
                       @RequestParam Double price) {
        return "book name is " + name + ", price is " + price;

    }

    @GetMapping("{name}")
    public Book getByName(@PathVariable String name) {
        return new Book(1001l,name, 100.0);
    }

    @PostMapping("create")
    public Book create(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("query")
    public String query(@RequestParam Long id,
                      @RequestParam String name,
                      @RequestParam Double price) {
        return "id is " + id + ", name is " + name + ", price is " + price;
    }

    @GetMapping("query/{id}")
    public Book queryById(@PathVariable Long id) {
        return bookService.getBookById(id);

    }

    @GetMapping("optional")
    public String optional(@RequestParam(required = false) Long id,
                           @RequestParam(required = false) String name,
                      @RequestParam(required = false) Double price){
        return "id is " + id + ", name is " + name + ", price is " + price;
    }

    @GetMapping("default")
    public String defaultQuery(@RequestParam(defaultValue = "1001") Long id,
                               @RequestParam(defaultValue = "java") String name,
                      @RequestParam(defaultValue = "100.0") Double price) {
        return "id is " + id + ", name is " + name + ", price is " + price;
    }
}
