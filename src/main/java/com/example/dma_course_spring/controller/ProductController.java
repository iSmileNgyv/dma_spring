package com.example.dma_course_spring.controller;

import com.example.dma_course_spring.dto.product.create.CreateProductRequestDto;
import com.example.dma_course_spring.dto.product.create.CreateProductResponseDto;
import com.example.dma_course_spring.dto.product.getAll.GetAllProductResponseDto;
import com.example.dma_course_spring.dto.product.update.UpdateProductRequestDto;
import com.example.dma_course_spring.dto.product.update.UpdateProductResponseDto;
import com.example.dma_course_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public CreateProductResponseDto create(@RequestBody  CreateProductRequestDto request) {
        return productService.createProduct(request);
    }

    @PutMapping
    public UpdateProductResponseDto update(@RequestBody UpdateProductRequestDto request) throws Exception {
        return productService.updateProduct(request);
    }

    @GetMapping("all")
    public List<GetAllProductResponseDto> getAll() {
        return productService.getAll();
    }
}
