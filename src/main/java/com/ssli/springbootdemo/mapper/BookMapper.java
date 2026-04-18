package com.ssli.springbootdemo.mapper;

import com.ssli.springbootdemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
    Book selectById(Long id);
    Book selectByName(String name);
    int insert(Book book);
}
