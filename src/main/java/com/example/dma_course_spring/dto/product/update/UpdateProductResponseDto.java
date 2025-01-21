package com.example.dma_course_spring.dto.product.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponseDto {
    private int id;
    private String name;
    private Double price;
}
