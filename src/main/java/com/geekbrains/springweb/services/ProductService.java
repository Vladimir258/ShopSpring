package com.geekbrains.springweb.services;

import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long productId, Float sale) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + sale);
    }

}
