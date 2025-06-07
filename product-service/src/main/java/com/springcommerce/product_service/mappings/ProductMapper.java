package com.springcommerce.product_service.mappings;

import com.springcommerce.product_service.dto.*;
import com.springcommerce.product_service.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponse  toResponseDTO(Product product) {
        List<CategoryDTO> categoryDTOs = product.getCategories().stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getCategory()))
                .collect(Collectors.toList());

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .categories(categoryDTOs)
                .build();
    }

    public static Product toEntity(ProductRequest  dto, List<Category> categories) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .categories(categories)
                .imageMinioPath(dto.getImageMinioPath())
                .build();
    }
}
