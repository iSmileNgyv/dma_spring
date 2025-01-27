package com.example.dma_course_spring.dto.product.getAll;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetNamePriceResponseDto {
    private String name;
    private Double price;
}
