package com.springcommerce.product_service.service;

import com.springcommerce.product_service.dto.ProductRequest;
import com.springcommerce.product_service.dto.ProductResponse;
import com.springcommerce.product_service.entity.Product;
import java.util.List;

public interface ProductService {
    ProductResponse addProduct(ProductRequest request);
    List<ProductResponse> getAllProducts();
}
