package com.example.dma_course_spring.dto.student.getAll;

import com.example.dma_course_spring.util.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GetAllStudentResponseDto {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private String courseName;
}
