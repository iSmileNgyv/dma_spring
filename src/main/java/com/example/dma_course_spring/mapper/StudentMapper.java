package com.example.dma_course_spring.mapper;

import com.example.dma_course_spring.dto.student.getAll.GetAllStudentResponseDto;
import com.example.dma_course_spring.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentMapper {
    private GetAllStudentResponseDto toResponseDto(StudentEntity student) {
        return GetAllStudentResponseDto.builder()
                //.id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .build();
    }

    public List<GetAllStudentResponseDto> toResponseDtoList(List<StudentEntity> students) {
        List<GetAllStudentResponseDto> dtoList = new ArrayList<>();
        for (StudentEntity student : students) {
            dtoList.add(toResponseDto(student));
        }
        return dtoList;
    }
}
