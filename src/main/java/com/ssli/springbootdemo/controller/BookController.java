package com.ssli.springbootdemo.controller;

import com.ssli.springbootdemo.common.Result;
import com.ssli.springbootdemo.dto.BookCreateDTO;
import com.ssli.springbootdemo.entity.Book;
import com.ssli.springbootdemo.service.BookService;
import com.ssli.springbootdemo.vo.BookVO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello book";
    }

    @PostMapping("/create")
    public Result<BookVO> create(@Valid @RequestBody BookCreateDTO dto) {



        Book createdBook = bookService.createBook(toEntity(dto));

        BookVO vo = toVO(createdBook);

        return Result.success("创建成功", vo);
    }

    @GetMapping("/query/{id}")
    public Result<BookVO> queryById(@PathVariable Long id) {
        Book book =  bookService.getBookById(id);
        BookVO vo = toVO(book);
        return Result.success(vo);

    }

    private Book toEntity(BookCreateDTO dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        return book;
    }

    private BookVO toVO(Book book) {
        return new BookVO(book.getId(), book.getName(), book.getPrice() + "元");
    }

}
