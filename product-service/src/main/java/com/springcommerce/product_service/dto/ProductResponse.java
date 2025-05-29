package com.springcommerce.product_service.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private Long id;

    private String name;

    private String description;

    private String category;

    private double price;

    private int quantity;
}
