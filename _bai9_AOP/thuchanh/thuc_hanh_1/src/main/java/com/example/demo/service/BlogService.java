package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id) throws Exception;

    void save(Blog blog);

    void deleteById(Long id);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long id, Pageable pageable);



}
