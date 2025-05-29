package com.springcommerce.product_service.service;

import com.springcommerce.product_service.dto.ProductResponse;
import com.springcommerce.product_service.entity.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);
    List<ProductResponse> searchProductsByName(String name);
    List<ProductResponse> getProductsByCategory(String category);
}
