package com.springcommerce.product_service.repository;

import com.springcommerce.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findByNameContainingIgnoreCase(String name);
//    List<Product> findByCategory(String category);
}
