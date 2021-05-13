package com.example.demo.service;

import com.example.demo.model.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDetailService {

    Page<ProductDetail> findAll(Pageable pageable);

    List<ProductDetail> findAll();
}
