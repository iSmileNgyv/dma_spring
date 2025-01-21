package com.example.dma_course_spring.util.mock;

import com.example.dma_course_spring.dto.book.getAll.GetAllBookResponseDto;
import com.example.dma_course_spring.util.enums.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookMock implements Mock<GetAllBookResponseDto>{
    private List<GetAllBookResponseDto> data = new ArrayList<GetAllBookResponseDto>();
    private void setData() {
        this.data.add(new GetAllBookResponseDto(1, "Test name1", "Test author1", Genre.ART));
        this.data.add(new GetAllBookResponseDto(2, "Test name2", "Test author2", Genre.HISTORY));
    }
    @Override
    public List<GetAllBookResponseDto> getAll() {
        this.setData();
        return this.data;
    }
}
