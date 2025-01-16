package com.example.dma_course_spring.controller;

import com.example.dma_course_spring.dto.student.create.CreateStudentRequestDto;
import com.example.dma_course_spring.dto.student.create.CreateStudentResponse;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentResponseDto;
import com.example.dma_course_spring.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public CreateStudentResponse createStudent(@RequestBody CreateStudentRequestDto dto) {
        return studentService.createStudent(dto);
    }

    @GetMapping
    public List<GetAllStudentResponseDto> getAll(@RequestBody GetAllStudentRequestDto dto) {
        return studentService.getAll(dto);
    }

    @GetMapping("all")
    public List<GetAllStudentResponseDto> getAll() {
        return studentService.getAll(null);
    }
}
