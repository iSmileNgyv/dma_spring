package com.example.dma_course_spring.dto.student.update;

import com.example.dma_course_spring.util.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentResponseDto {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
}
