package com.example.dma_course_spring.mapper;

import com.example.dma_course_spring.dto.product.getAll.GetAllProductResponseDto;
import com.example.dma_course_spring.entity.ProductEntity;
import com.example.dma_course_spring.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductMapper {
    private GetAllProductResponseDto toResponseDto(ProductEntity product) {
        return GetAllProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .createdAt(DateUtil.formatDate(product.getCreatedAt()))
                .updatedAt(DateUtil.formatDate(product.getUpdatedAt()))
                .build();
    }

    public List<GetAllProductResponseDto> toResponseDtoList(List<ProductEntity> products) {
        List<GetAllProductResponseDto> dtoList = new ArrayList<>();
        for (ProductEntity product : products) {
            dtoList.add(toResponseDto(product));
        }
        return dtoList;
    }
}
