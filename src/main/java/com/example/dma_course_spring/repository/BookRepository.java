package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> { }
