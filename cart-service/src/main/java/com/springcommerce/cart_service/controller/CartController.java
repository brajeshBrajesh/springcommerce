package com.springcommerce.cart_service.controller;

import com.springcommerce.cart_service.dto.AddToCartRequest;
import com.springcommerce.cart_service.dto.CustomUserPrincipal;
import com.springcommerce.cart_service.service.CartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/test")
    @SecurityRequirement(name = "bearerAuth")
    public String test(){
        return "Test passed";
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("test2")
    public String temp2(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUserPrincipal user = (CustomUserPrincipal) authentication.getPrincipal();
        Long userId = user.getId();
        System.out.println(userId);
        return "HI";
    }
    @PostMapping("/add")
    @SecurityRequirement(name="bearerAuth")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUserPrincipal user = (CustomUserPrincipal) authentication.getPrincipal();
        Long userId = user.getId();
        cartService.addToCart(userId,request);
        return ResponseEntity.ok("Item added");
    }
}
