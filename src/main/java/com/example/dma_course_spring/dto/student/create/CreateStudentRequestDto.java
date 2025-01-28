package com.example.dma_course_spring.dto.student.create;

import com.example.dma_course_spring.dto.student.BaseDto;
import com.example.dma_course_spring.util.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequestDto extends BaseDto {
    private String name;
    private String surname;
    private Gender gender;
    private int courseId;
}
