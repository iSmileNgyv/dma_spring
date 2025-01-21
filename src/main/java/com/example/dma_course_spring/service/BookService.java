package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.book.create.CreateBookRequestDto;
import com.example.dma_course_spring.dto.book.create.CreateBookResponseDto;
import com.example.dma_course_spring.dto.book.getAll.GetAllBookResponseDto;
import com.example.dma_course_spring.entity.BookEntity;
import com.example.dma_course_spring.mapper.BookMapper;
import com.example.dma_course_spring.repository.BookRepository;
import com.example.dma_course_spring.util.mock.BookMock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<GetAllBookResponseDto> getAllMock() {
        return new BookMock().getAll();
    }

    public List<GetAllBookResponseDto> getAll() {
        List<BookEntity> response = bookRepository.findAll();
        return new BookMapper().toResponseDtoList(response);
    }

    public CreateBookResponseDto create(CreateBookRequestDto dto) {
        var bookEntity = new BookEntity();
        bookEntity.setName(dto.getName());
        bookEntity.setAuthor(dto.getAuthor());
        bookEntity.setGenre(dto.getGenre());
        try {
            bookRepository.save(bookEntity);
            var returnResponse = new CreateBookResponseDto();
            returnResponse.setSuccess(true);
            return returnResponse;
        }catch(Exception ex) {
            var returnResponse = new CreateBookResponseDto();
            returnResponse.setSuccess(false);
            return returnResponse;
        }
    }
}
