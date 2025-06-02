package com.springcommerce.cart_service.service;

import com.springcommerce.cart_service.dto.AddToCartRequest;

public interface CartService {

    void addToCart(Long userId,AddToCartRequest request);

}
