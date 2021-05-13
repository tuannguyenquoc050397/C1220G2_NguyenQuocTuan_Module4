package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Long id);

    void save(Product product);

    void deleteById(Long id);

    Page<Product> findAllByNameContainingOrProductDetail_Cost(String name
            , double cost, Pageable pageable);
}
