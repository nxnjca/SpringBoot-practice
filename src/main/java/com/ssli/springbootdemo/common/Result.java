package com.ssli.springbootdemo.common;

import lombok.Data;

@Data
public class Result <T>{

    private Integer code;
    private String message;
    private T data;

    public Result() {

    }
    public Result(Integer code, String success, T data) {
        setCode(code);
        setMessage(success);
        setData(data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200,"success",data);
    }

    public static <T> Result<T> success(String message,T data) {
        return new Result<>(200,message, data);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

}
