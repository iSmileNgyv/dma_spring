package com.example.dma_course_spring.dto.course.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequestDto {
    private int id;
    private String name;
}
