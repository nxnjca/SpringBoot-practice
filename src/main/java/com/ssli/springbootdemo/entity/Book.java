package com.ssli.springbootdemo.entity;


import lombok.Data;

@Data
public class Book {
    private String name;
    private Double price;

    public Book() {
    }

    public Book(String name, double v) {
        setName(name);
        setPrice(v);
    }
}
