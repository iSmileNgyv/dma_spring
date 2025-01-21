package com.example.dma_course_spring.dto.book.create;

import com.example.dma_course_spring.util.enums.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequestDto {
    private String name;
    private String author;
    private Genre genre;
}
