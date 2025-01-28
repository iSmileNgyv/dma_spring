package com.example.dma_course_spring.dto.student.create;

import com.example.dma_course_spring.dto.student.BaseDto;
import com.example.dma_course_spring.util.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateStudentResponse extends BaseDto {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private String courseName;
}
