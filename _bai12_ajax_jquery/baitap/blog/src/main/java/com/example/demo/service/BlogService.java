package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {

    List<Blog> findAllByNameContaining(String name);
    List<Blog> findAll();

    List<Blog> findLimit(int limit);


}
