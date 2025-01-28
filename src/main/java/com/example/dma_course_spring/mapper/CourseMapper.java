package com.example.dma_course_spring.mapper;
import com.example.dma_course_spring.dto.course.getAll.GetAllCourseResponseDto;
import com.example.dma_course_spring.entity.CourseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {
    private GetAllCourseResponseDto toResponseDto(CourseEntity course) {
        return GetAllCourseResponseDto.builder()
                .id(course.getId())
                .name(course.getName())
                .build();
    }

    public List<GetAllCourseResponseDto> toResponseDtoList(List<CourseEntity> courses) {
        List<GetAllCourseResponseDto> dtoList = new ArrayList<>();
        for (CourseEntity course : courses) {
            dtoList.add(toResponseDto(course));
        }
        return dtoList;
    }
}
