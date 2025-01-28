package com.example.dma_course_spring.dto.course.getAll;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCourseResponseDto {
    private int id;
    private String name;
}
