package com.geekbrains.springweb.controllers;

import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.services.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_price") // Применяем к  цене скидку
    public void changePrice(@RequestParam Long productId, @RequestParam Float sale) {
        productService.changePrice(productId, sale);
    }

//    @GetMapping("/products")
//    public String showProductsPage(Model model) {
//        model.addAttribute("products", productRepository.getAllProducts());
//        return "products_page";
//    }

//    @GetMapping("/products/{id}")
//    public String showProductPage(Model model, @PathVariable Long id) {
//        Product product = productRepository.findById(id);
//        model.addAttribute("product", product);
//        return "product_info_page";
//    }
}
