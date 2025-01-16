package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.student.create.CreateStudentRequestDto;
import com.example.dma_course_spring.dto.student.create.CreateStudentResponse;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentResponseDto;
import com.example.dma_course_spring.entity.StudentEntity;
import com.example.dma_course_spring.repository.StudentRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponse createStudent(CreateStudentRequestDto dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        StudentEntity response = studentRepository.save(entity);

        return new CreateStudentResponse(response.getId(), response.getName(), response.getSurname());
    }

    public List<GetAllStudentResponseDto> getAll(@Nullable GetAllStudentRequestDto dto) {
        List<StudentEntity> response = studentRepository.findAll();
        return response.stream()
                .map(student -> new GetAllStudentResponseDto(student.getId(), student.getName(), student.getSurname()))
                .collect(Collectors.toList());
    }
}
