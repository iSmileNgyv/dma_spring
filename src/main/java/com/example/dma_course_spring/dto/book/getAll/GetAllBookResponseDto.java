package com.example.dma_course_spring.dto.book.getAll;

import com.example.dma_course_spring.util.enums.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllBookResponseDto {
    private long id;
    private String name;
    private String author;
    private Genre genre;
}
