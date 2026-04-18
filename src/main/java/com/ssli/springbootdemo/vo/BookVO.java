package com.ssli.springbootdemo.vo;

import lombok.Data;

@Data
public class BookVO {
    private Long id;
    private String name;
    private String priceText;

    public BookVO() {
    }

    public BookVO(Long id, String name, String priceText) {
        this.id = id;
        this.name = name;
        this.priceText = priceText;
    }
}
