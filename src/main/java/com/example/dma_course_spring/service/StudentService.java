package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.student.create.CreateStudentRequestDto;
import com.example.dma_course_spring.dto.student.create.CreateStudentResponse;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentByNameRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentResponseDto;
import com.example.dma_course_spring.dto.student.remove.RemoveStudentRequestDto;
import com.example.dma_course_spring.entity.StudentEntity;
import com.example.dma_course_spring.mapper.StudentMapper;
import com.example.dma_course_spring.repository.StudentRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public CreateStudentResponse createStudent(CreateStudentRequestDto dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setGender(dto.getGender());
        StudentEntity response = studentRepository.save(entity);

        return new CreateStudentResponse(response.getId(), response.getName(), response.getSurname(), response.getGender());
    }

    public List<GetAllStudentResponseDto> getAll(@Nullable GetAllStudentRequestDto dto) {
        List<StudentEntity> response = studentRepository.findAll();
        return studentMapper.toResponseDtoList(response);
    }

    public List<GetAllStudentResponseDto> filterByName(GetAllStudentByNameRequestDto request) {
        List<StudentEntity> response = studentRepository.filterByName("%" + request.getName().toLowerCase() + "%");
        return studentMapper.toResponseDtoList(response);
    }

    public void removeStudent(RemoveStudentRequestDto request) throws Exception{
        var entity = studentRepository.findById(request.getId());
        if(entity.isEmpty())
            throw new Exception("Student not found");
        studentRepository.deleteById(entity.get().getId());
    }
}
