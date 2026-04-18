package com.ssli.springbootdemo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookCreateDTO {

    @NotNull(message = "图书名称不能为空")
    private String name;

    @NotNull(message = "图书价格不能为空")
    @DecimalMin(value = "0.0",inclusive = false,message = "图书价格不能小于0")
    private Double price;

}
