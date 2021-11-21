package com.geekbrains.springweb.repository;

import com.geekbrains.springweb.dao.ProductDao;
import com.geekbrains.springweb.dao.ProductDaoImpl;
import com.geekbrains.springweb.model.Product;
import com.geekbrains.springweb.utils.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;
    private SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
    @PostConstruct
    public void init() {
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            products = productDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }

    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
}
