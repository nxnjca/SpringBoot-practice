package com.ssli.springbootdemo.dto;

import lombok.Data;

@Data
public class BookQueryDTO {
    private String name;
    private Double minPrice;
    private Double maxPrice;
    private Integer pageNum;
    private Integer pageSize;
    private Integer offset;
}
