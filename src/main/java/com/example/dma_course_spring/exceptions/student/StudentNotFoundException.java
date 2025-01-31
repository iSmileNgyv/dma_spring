package com.example.dma_course_spring.exceptions.student;

import com.example.dma_course_spring.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends BaseException {
    public StudentNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }

    public StudentNotFoundException() {
      super("Student not found", HttpStatus.NOT_FOUND.value());
    }
}