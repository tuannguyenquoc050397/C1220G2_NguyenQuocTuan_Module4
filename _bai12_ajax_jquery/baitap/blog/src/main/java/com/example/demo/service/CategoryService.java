package com.example.demo.service;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void deleteById(Long id);
}
