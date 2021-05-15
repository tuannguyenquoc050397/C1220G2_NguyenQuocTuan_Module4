package com.example.demo.service.impl;

import com.example.demo.model.ProductDetail;
import com.example.demo.repository.ProductDetailRepository;
import com.example.demo.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;


    @Override
    public Page<ProductDetail> findAll(Pageable pageable) {
        return productDetailRepository.findAll(pageable);
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }
}
