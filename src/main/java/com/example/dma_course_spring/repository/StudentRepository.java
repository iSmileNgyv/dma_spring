package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query(value="SELECT s FROM StudentEntity s WHERE LOWER(s.name) LIKE :name")
    List<StudentEntity> filterByName(@Param("name") String name);
}
