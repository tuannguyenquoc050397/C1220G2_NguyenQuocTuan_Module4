package com.example.demo.repository;

import com.example.demo.model.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
