package com.service.impl;

import com.model.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {


    private static final Map<String, Product> products;

    static {

        products = new TreeMap<>();
        products.put("123", new Product("123", "Iphone 11", 100, "dep vcl1", "Apple"));
        products.put("221", new Product("221", "SamSung edge", 200, "dep vcl2", "Samsung"));
        products.put("341", new Product("341", "VinSmart 11", 300, "dep vcl3", "Vin"));
        products.put("165", new Product("165", "Oppo MTP", 400, "dep vcl4", "Oppo"));
        products.put("921", new Product("921", "Ronaldo 7", 600, "dep vcl5", "human"));
        products.put("789", new Product("789", "Messi 10", 500, "dep vcl6", "human"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
    products.put(product.getId(),product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public void update(String id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }
}
