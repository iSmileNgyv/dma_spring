package com.example.dma_course_spring.repository;

import com.example.dma_course_spring.dto.product.getAll.GetGroupByPriceResponseDto;
import com.example.dma_course_spring.dto.product.getAll.GetNamePriceResponseDto;
import com.example.dma_course_spring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = "SELECT p FROM ProductEntity p WHERE p.price BETWEEN :from AND :to")
    List<ProductEntity> findBetweenPrices(@Param("from") double from, @Param("to") double to);

    @Query(value="SELECT p FROM ProductEntity p WHERE LOWER(p.name) LIKE :name")
    List<ProductEntity> findByName(@Param("name") String name);

    @Query(value="SELECT COUNT(p) FROM ProductEntity p")
    Long totalCount();

    @Query(value="SELECT MAX(p.price) FROM ProductEntity p")
    Double maxPrice();

    @Query(value="SELECT p FROM ProductEntity p ORDER BY p.createdAt ASC LIMIT 10")
    List<ProductEntity> getByCreatedAtAsc();

    @Query(value="SELECT AVG(p.price) FROM ProductEntity p")
    Double averagePrice();

    @Query(value="SELECT new com.example.dma_course_spring.dto.product.getAll.GetGroupByPriceResponseDto(COUNT(p.id), p.price) FROM ProductEntity p GROUP BY p.price")
    List<GetGroupByPriceResponseDto> getGroupByPrice();

    @Query(value="SELECT new com.example.dma_course_spring.dto.product.getAll.GetNamePriceResponseDto(p.name, p.price) FROM ProductEntity p")
    List<GetNamePriceResponseDto> getNamePrice();

    @Query(value="SELECT p FROM ProductEntity p WHERE Date(p.createdAt) = :date")
    List<ProductEntity> findByCreatedAt(@Param("date")LocalDate date);

    @Query(value = "SELECT DISTINCT ON (p.name) * FROM product p ORDER BY p.name, p.id", nativeQuery = true)
    List<ProductEntity> getUniqueName();

    @Query(value="SELECT p FROM ProductEntity p WHERE p.name LIKE :name AND p.price > :price")
    List<ProductEntity> filterByNamePrice(@Param("name") String name, @Param("price") Double price);

}
