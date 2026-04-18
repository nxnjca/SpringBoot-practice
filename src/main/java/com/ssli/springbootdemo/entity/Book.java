package com.ssli.springbootdemo.entity;



import lombok.Data;

@Data
public class Book {

    private Long id;
    private String name;
    private Double price;

    public Book() {
    }

    public Book(Long id,String name, double v) {
        setId(id);
        setName(name);
        setPrice(v);
    }
}
