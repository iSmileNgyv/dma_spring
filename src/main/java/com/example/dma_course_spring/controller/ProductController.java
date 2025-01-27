package com.example.dma_course_spring.controller;

import com.example.dma_course_spring.dto.product.create.CreateProductRequestDto;
import com.example.dma_course_spring.dto.product.create.CreateProductResponseDto;
import com.example.dma_course_spring.dto.product.getAll.*;
import com.example.dma_course_spring.dto.product.update.UpdateProductRequestDto;
import com.example.dma_course_spring.dto.product.update.UpdateProductResponseDto;
import com.example.dma_course_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("between")
    public List<GetAllProductResponseDto> getBetween(@ModelAttribute GetAllProductBetweenPricesRequestDto request) {
        return productService.getBetweenPrices(request);
    }

    @GetMapping("search")
    public List<GetAllProductResponseDto> getByName(@ModelAttribute GetAllProductByNameRequestDto request) {
        return productService.getByName(request);
    }

    @GetMapping("totalCount")
    public GetTotalCountResponseDto totalCount() {
        return productService.totalCount();
    }

    @GetMapping("maxPrice")
    public GetMaxPriceResponseDto maxPrice() {
        return productService.maxPrice();
    }

    @GetMapping("getByCreatedAtAsc")
    public List<GetAllProductResponseDto> getByCreatedAtAsc() {
        return productService.getByCreatedAtAsc();
    }

    @GetMapping("averagePrice")
    public GetAveragePriceResponseDto averagePrice() {
        return productService.averagePrice();
    }

    @GetMapping("groupByPrice")
    public List<GetGroupByPriceResponseDto> groupByPrice() {
        return productService.getGroupByPrice();
    }

    @GetMapping("namePrice")
    public List<GetNamePriceResponseDto> getNamePrice() {
        return productService.getNamePrice();
    }

    @GetMapping("findByCreatedAt")
    public List<GetAllProductResponseDto> findByCreatedAt(@RequestParam LocalDate date) {
        return productService.findByCreatedAt(date);
    }

    @GetMapping("uniqueName")
    public List<GetAllProductResponseDto> getUniqueName() {
        return productService.getUniqueName();
    }

    @GetMapping("filterByNamePrice")
    public List<GetAllProductResponseDto> filterByNamePrice(@ModelAttribute FilterByNamePriceRequestDto request) {
        return productService.filterByNamePrice(request);
    }
}
