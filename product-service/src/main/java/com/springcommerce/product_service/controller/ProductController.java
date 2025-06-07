package com.springcommerce.product_service.controller;

import com.springcommerce.product_service.dto.ProductRequest;
import com.springcommerce.product_service.dto.ProductResponse;
import com.springcommerce.product_service.entity.Product;
import com.springcommerce.product_service.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductServiceImpl productService;

    @PostMapping("/add-product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request){
        ProductResponse response=productService.addProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/get-all-products")
    public ResponseEntity<List<ProductResponse>> getAppProducts(){
        List<ProductResponse> allProducts=productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body(allProducts);
    }

}
