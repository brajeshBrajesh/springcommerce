package com.springcommerce.product_service.service;

import com.springcommerce.product_service.dto.CategoryDTO;
import com.springcommerce.product_service.dto.ProductRequest;
import com.springcommerce.product_service.dto.ProductResponse;
import com.springcommerce.product_service.entity.Category;
import com.springcommerce.product_service.entity.Product;
import com.springcommerce.product_service.mappings.ProductMapper;
import com.springcommerce.product_service.repository.CategoryRepository;
import com.springcommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse addProduct(ProductRequest request){
        List<Category> categories= categoryRepository.findAllById(request.getCategoryIds());

        if (categories.size() != request.getCategoryIds().size()) {
            throw new IllegalArgumentException("One or more category IDs are invalid.");
        }

        Product product= ProductMapper.toEntity(request,categories);
        Product saved= productRepository.save(product);
        return ProductMapper.toResponseDTO(saved);

    }
    @Override
    public List<ProductResponse> getAllProducts(){
        List<Product> allProducts=productRepository.findAll();
        List<ProductResponse> temp=new ArrayList<>();

        for(Product p : allProducts){
            ProductResponse pr=ProductMapper.toResponseDTO(p);
            temp.add(pr);
        }
        return temp;
    }
}