package com.example.dma_course_spring.dto.product.getAll;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponseDto {
    private int id;
    private String name;
    private double price;
    private String createdAt;
    private String updatedAt;
}
