package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> { }
