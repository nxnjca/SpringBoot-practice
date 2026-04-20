package com.ssli.springbootdemo.mapper;

import com.ssli.springbootdemo.dto.BookQueryDTO;
import com.ssli.springbootdemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    Book selectById(Long id);
    Book selectByName(String name);
    int insert(Book book);

    int deleteById(Long id);

    int updateById(Book book);

    List<Book> selectList(BookQueryDTO dto);
}
