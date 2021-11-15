package com.geekbrains.springweb.controllers;

import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {
    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }
}
