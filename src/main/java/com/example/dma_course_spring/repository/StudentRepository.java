package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> { }
