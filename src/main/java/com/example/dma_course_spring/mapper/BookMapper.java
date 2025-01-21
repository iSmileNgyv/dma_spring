package com.example.dma_course_spring.mapper;

import com.example.dma_course_spring.dto.book.getAll.GetAllBookResponseDto;
import com.example.dma_course_spring.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {
    private GetAllBookResponseDto toResponseDto(BookEntity book) {
        return GetAllBookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .build();
    }

    public List<GetAllBookResponseDto> toResponseDtoList(List<BookEntity> books) {
        List<GetAllBookResponseDto> dtoList = new ArrayList<>();
        for (BookEntity book : books) {
            dtoList.add(toResponseDto(book));
        }
        return dtoList;
    }
}
