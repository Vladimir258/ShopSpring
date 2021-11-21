package com.geekbrains.springweb.dao;

import com.geekbrains.springweb.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    Product findByTitle(String title);
    List<Product> findAll();
    void save(Product product);
    void updateById(Long id, String newTitle);
}
