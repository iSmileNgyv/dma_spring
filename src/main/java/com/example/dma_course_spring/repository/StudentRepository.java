package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query(value="SELECT s FROM StudentEntity s WHERE LOWER(s.name) LIKE :name")
    List<StudentEntity> filterByName(@Param("name") String name);
}
