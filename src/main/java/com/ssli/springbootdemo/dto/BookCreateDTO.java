package com.ssli.springbootdemo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for creating a new book.
 * This class is used to transfer book creation data between the client and server.
 * It includes validation annotations to ensure the data integrity.
 */
@Data
public class BookCreateDTO {

    @NotBlank(message = "图书名称不能为空")
    private String name;

    @NotNull(message = "图书价格不能为空")
    @DecimalMin(value = "0.0",inclusive = false,message = "图书价格不能小于0")
    private Double price;

}
