package com.example.dma_course_spring.dto.student.getAll;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GetAllStudentResponseDto {
    //private long id;
    private String name;
    private String surname;
}
