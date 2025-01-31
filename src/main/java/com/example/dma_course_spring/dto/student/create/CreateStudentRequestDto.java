package com.example.dma_course_spring.dto.student.create;

import com.example.dma_course_spring.dto.student.BaseDto;
import com.example.dma_course_spring.util.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequestDto extends BaseDto {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    @Size(max = 10, message = "Name max 10")
    private String name;
    @NotBlank(message = "Surname cannot be null")
    private String surname;
    private Gender gender;
    private int courseId;
}
