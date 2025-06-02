package com.springcommerce.cart_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public  class CustomUserPrincipal {
    private Long id;
    private String username;
    private String role;
}