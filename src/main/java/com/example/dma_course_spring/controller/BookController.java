package com.example.dma_course_spring.controller;

import com.example.dma_course_spring.dto.book.create.CreateBookRequestDto;
import com.example.dma_course_spring.dto.book.create.CreateBookResponseDto;
import com.example.dma_course_spring.dto.book.getAll.GetAllBookResponseDto;
import com.example.dma_course_spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    public List<GetAllBookResponseDto> getAll() {
        return this.bookService.getAll();
    }

    @PostMapping
    public CreateBookResponseDto create(@RequestBody CreateBookRequestDto dto) {
        return this.bookService.create(dto);
    }
}