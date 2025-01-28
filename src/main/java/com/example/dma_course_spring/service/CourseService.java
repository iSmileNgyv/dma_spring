package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.course.create.CreateCourseRequestDto;
import com.example.dma_course_spring.dto.course.create.CreateCourseResponseDto;
import com.example.dma_course_spring.dto.course.getAll.GetAllCourseResponseDto;
import com.example.dma_course_spring.dto.course.remove.RemoveCourseRequestDto;
import com.example.dma_course_spring.dto.course.remove.RemoveCourseResponseDto;
import com.example.dma_course_spring.dto.course.update.UpdateCourseRequestDto;
import com.example.dma_course_spring.dto.course.update.UpdateCourseResponseDto;
import com.example.dma_course_spring.entity.CourseEntity;
import com.example.dma_course_spring.mapper.CourseMapper;
import com.example.dma_course_spring.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CreateCourseResponseDto createCourse(CreateCourseRequestDto request) {
        var entity = new CourseEntity();
        entity.setName(request.getName());
        courseRepository.save(entity);

        return new CreateCourseResponseDto(entity.getId(), entity.getName());
    }

    public List<GetAllCourseResponseDto> getAll() {
        var response = courseRepository.findAll();
        return courseMapper.toResponseDtoList(response);
    }

    public UpdateCourseResponseDto update(UpdateCourseRequestDto request) {
        var entity = new CourseEntity();
        entity.setId(request.getId());
        entity.setName(request.getName());
        courseRepository.save(entity);

        return new UpdateCourseResponseDto(
                entity.getId(),
                entity.getName()
        );
    }

    public RemoveCourseResponseDto remove(RemoveCourseRequestDto request) throws Exception {
        try {
            courseRepository.deleteById(request.getId());
            return new RemoveCourseResponseDto("Deleted successfully");
        }catch(Exception ex) {
            throw new Exception("You cannot delete this course");
        }

    }
}
