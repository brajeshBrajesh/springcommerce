package com.springcommerce.product_service.service;

import com.springcommerce.product_service.dto.ProductRequest;
import com.springcommerce.product_service.dto.ProductResponse;
import com.springcommerce.product_service.entity.Product;
import com.springcommerce.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public  List<ProductResponse> getAllProducts() {
        List<Product> allProducts=productRepository.findAll();
        List<ProductResponse> responseProductsList=new ArrayList<ProductResponse>();
        for(Product product : allProducts){
            ProductResponse productResponse=this.mapToResponse(product);
            responseProductsList.add(productResponse);
        }
        return responseProductsList;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product= productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return this.mapToResponse(product);
    }

    @Override
    public List<ProductResponse> searchProductsByName(String name) {
//        return productRepository.findByNameContainingIgnoreCase(name);

        List<Product> allProducts=productRepository.findByNameContainingIgnoreCase(name);
        List<ProductResponse> responseProductsList=new ArrayList<ProductResponse>();
        for(Product product : allProducts){
            ProductResponse productResponse=this.mapToResponse(product);
            responseProductsList.add(productResponse);
        }
        return responseProductsList;
    }

    @Override
    public List<ProductResponse> getProductsByCategory(String category) {
        List<Product> allProducts=productRepository.findByCategory(category);
        List<ProductResponse> responseProductsList=new ArrayList<ProductResponse>();
        for(Product product : allProducts){
            ProductResponse productResponse=this.mapToResponse(product);
            responseProductsList.add(productResponse);
        }
        return responseProductsList;
    }

    public ProductResponse mapToResponse(Product product){
        ProductResponse response=new ProductResponse();
        response.setId(product.getId());
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setCategory(product.getCategory());
        return response;
    }

    public Product mapToEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        return product;
    }
}