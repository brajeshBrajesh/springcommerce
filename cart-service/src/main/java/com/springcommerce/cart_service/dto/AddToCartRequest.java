package com.springcommerce.cart_service.dto;

import lombok.Data;


@Data
public class AddToCartRequest {
    private Long productId;
    private int quantity;
    private double price;
}
