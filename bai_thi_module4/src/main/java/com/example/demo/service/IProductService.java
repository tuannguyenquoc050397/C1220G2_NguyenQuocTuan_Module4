package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void deleteById(Integer id);
    Product findById(Integer id);
    void save(Product product);
    Page<Product> findSearch(String name, Integer cost, String category, Pageable pageable);
}
