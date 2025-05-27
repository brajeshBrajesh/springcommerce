package com.springcommerce.product_service.service;

import com.springcommerce.product_service.entity.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> searchProductsByName(String name);
    List<Product> getProductsByCategory(String category);
}
