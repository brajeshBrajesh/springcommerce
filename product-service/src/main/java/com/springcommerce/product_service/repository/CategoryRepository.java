package com.springcommerce.product_service.repository;

import com.springcommerce.product_service.dto.CategoryDTO;

import com.springcommerce.product_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    List<Category> findAllById(List<Integer> ids);
}
