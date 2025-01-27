package com.example.dma_course_spring.service;

import com.example.dma_course_spring.dto.product.create.CreateProductRequestDto;
import com.example.dma_course_spring.dto.product.create.CreateProductResponseDto;
import com.example.dma_course_spring.dto.product.getAll.*;
import com.example.dma_course_spring.dto.product.update.UpdateProductRequestDto;
import com.example.dma_course_spring.dto.product.update.UpdateProductResponseDto;
import com.example.dma_course_spring.entity.ProductEntity;
import com.example.dma_course_spring.mapper.ProductMapper;
import com.example.dma_course_spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    public CreateProductResponseDto createProduct(CreateProductRequestDto dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        var response = new CreateProductResponseDto();
        try {
            productRepository.save(productEntity);
            response.setSuccess(true);
        } catch (Exception ex) {
            response.setSuccess(false);
        }
        return response;
    }

    public UpdateProductResponseDto updateProduct(UpdateProductRequestDto dto) throws Exception {
        Optional<ProductEntity> entity = productRepository.findById(dto.getId());
        if(entity.isPresent()) {
            ProductEntity productEntity = entity.get();
            if (dto.getName() != null && !dto.getName().isEmpty()) {
                productEntity.setName(dto.getName());
            }
            if (dto.getPrice() != null && dto.getPrice() > 0.0) {
                productEntity.setPrice(dto.getPrice());
            }
            productRepository.save(productEntity);
            var response = new UpdateProductResponseDto();
            response.setId(productEntity.getId());
            response.setPrice(productEntity.getPrice());
            response.setName(productEntity.getName());
            return response;
        }
        throw new Exception(dto.getId() + " id not found");
    }

    public List<GetAllProductResponseDto> getAll() {
        List<ProductEntity> response = productRepository.findAll();
        return productMapper.toResponseDtoList(response);
    }

    public List<GetAllProductResponseDto> getBetweenPrices(GetAllProductBetweenPricesRequestDto request) {
        List<ProductEntity> response = productRepository.findBetweenPrices(request.getFrom(), request.getTo());
        return productMapper.toResponseDtoList(response);
    }

    public List<GetAllProductResponseDto> getByName(GetAllProductByNameRequestDto request) {
        List<ProductEntity> response = productRepository.findByName("%" + request.getName().toLowerCase() + "%");
        return productMapper.toResponseDtoList(response);
    }

    public GetTotalCountResponseDto totalCount() {
        Long total = productRepository.totalCount();
        var response = new GetTotalCountResponseDto();
        response.setTotal(total);
        return response;
    }

    public GetMaxPriceResponseDto maxPrice() {
        Double maxPrice = productRepository.maxPrice();
        var response = new GetMaxPriceResponseDto();
        response.setMax(maxPrice);
        return response;
    }

    public List<GetAllProductResponseDto> getByCreatedAtAsc() {
        List<ProductEntity> response = productRepository.getByCreatedAtAsc();
        return productMapper.toResponseDtoList(response);
    }

    public GetAveragePriceResponseDto averagePrice() {
        Double avg = productRepository.averagePrice();
        return new GetAveragePriceResponseDto(avg);
    }

    public List<GetGroupByPriceResponseDto> getGroupByPrice() {
        return productRepository.getGroupByPrice();
    }

    public List<GetNamePriceResponseDto> getNamePrice() {
        return productRepository.getNamePrice();
    }

    public List<GetAllProductResponseDto> findByCreatedAt(LocalDate date) {
        var response = productRepository.findByCreatedAt(date);
        return productMapper.toResponseDtoList(response);
    }

    public List<GetAllProductResponseDto> getUniqueName() {
        var response = productRepository.getUniqueName();
        return productMapper.toResponseDtoList(response);
    }

    public List<GetAllProductResponseDto> filterByNamePrice(FilterByNamePriceRequestDto request) {
        var response = productRepository.filterByNamePrice("%" + request.getName() + "%", request.getPrice());
        return productMapper.toResponseDtoList(response);
    }
}
