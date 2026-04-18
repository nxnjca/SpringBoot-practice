package com.ssli.springbootdemo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookUpdateDTO {
    @NotBlank(message = "图书名称不能为空")
    private String name;

    @NotNull(message = "图书价格不能为空")
    @DecimalMin(value = "0.0",inclusive = false,message = "图书价格大于0")
    private Double price;
}
