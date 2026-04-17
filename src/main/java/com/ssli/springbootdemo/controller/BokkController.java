package com.ssli.springbootdemo.controller;

import com.ssli.springbootdemo.entity.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BokkController {
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
        return new Book(name, 100.0);
    }

    @PostMapping("create")
    public Book create(@RequestBody Book book) {
        return book;
    }
}
