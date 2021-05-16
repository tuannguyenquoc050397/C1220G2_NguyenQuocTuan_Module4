package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(Long id);

}
