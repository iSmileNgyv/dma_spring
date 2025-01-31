package com.example.dma_course_spring.controller;

import com.example.dma_course_spring.dto.course.create.CreateCourseRequestDto;
import com.example.dma_course_spring.dto.course.create.CreateCourseResponseDto;
import com.example.dma_course_spring.dto.course.getAll.GetAllCourseResponseDto;
import com.example.dma_course_spring.dto.course.remove.RemoveCourseRequestDto;
import com.example.dma_course_spring.dto.course.remove.RemoveCourseResponseDto;
import com.example.dma_course_spring.dto.course.update.UpdateCourseRequestDto;
import com.example.dma_course_spring.dto.course.update.UpdateCourseResponseDto;
import com.example.dma_course_spring.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CreateCourseResponseDto create(@RequestBody  CreateCourseRequestDto request) {
        return courseService.createCourse(request);
    }

    @GetMapping("all")
    public List<GetAllCourseResponseDto> getAll() {
        return courseService.getAll();
    }

    @PutMapping
    public UpdateCourseResponseDto update(@RequestBody UpdateCourseRequestDto request) {
        return courseService.update(request);
    }

    @DeleteMapping
    public ResponseEntity<RemoveCourseResponseDto> remove(@RequestBody RemoveCourseRequestDto request){
        try {
            RemoveCourseResponseDto response = courseService.remove(request);
            return ResponseEntity.ok(response);
        }catch(Exception ex) {
            RemoveCourseResponseDto errorResponse = new RemoveCourseResponseDto(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR) 
                    .body(errorResponse);
        }
    }
}
