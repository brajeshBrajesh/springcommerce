package com.springcommerce.product_service.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String imageMinioPath;
    private List<Integer> categoryIds; // IDs of categories the product belongs to
}
