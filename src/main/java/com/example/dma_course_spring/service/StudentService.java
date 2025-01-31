package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.student.create.CreateStudentRequestDto;
import com.example.dma_course_spring.dto.student.create.CreateStudentResponse;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentByNameRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentRequestDto;
import com.example.dma_course_spring.dto.student.getAll.GetAllStudentResponseDto;
import com.example.dma_course_spring.dto.student.remove.RemoveStudentRequestDto;
import com.example.dma_course_spring.dto.student.update.UpdateStudentRequestDto;
import com.example.dma_course_spring.dto.student.update.UpdateStudentResponseDto;
import com.example.dma_course_spring.entity.StudentEntity;
import com.example.dma_course_spring.exceptions.student.StudentNotFoundException;
import com.example.dma_course_spring.mapper.StudentMapper;
import com.example.dma_course_spring.repository.CourseRepository;
import com.example.dma_course_spring.repository.StudentRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.courseRepository = courseRepository;
    }

    public CreateStudentResponse createStudent(CreateStudentRequestDto dto)throws Exception {
        var course = courseRepository.findById(dto.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setGender(dto.getGender());
        entity.setCourseEntity(course);
        StudentEntity response = studentRepository.save(entity);

        return new CreateStudentResponse(
                response.getId(),
                response.getName(),
                response.getSurname(),
                response.getGender(),
                response.getCourseEntity().getName()
        );
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
            throw new StudentNotFoundException();
        studentRepository.deleteById(entity.get().getId());
    }

    public UpdateStudentResponseDto updateStudent(UpdateStudentRequestDto request) throws Exception{
        var entity = studentRepository.findById(request.getId());
        if(entity.isEmpty())
            throw new StudentNotFoundException();
        var course = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        var student = entity.get();
        student.setId(request.getId());
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setGender(request.getGender());
        student.setCourseEntity(course);
        studentRepository.save(student);

        return new UpdateStudentResponseDto(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getGender(),
                student.getCourseEntity().getName()
        );
    }
}
