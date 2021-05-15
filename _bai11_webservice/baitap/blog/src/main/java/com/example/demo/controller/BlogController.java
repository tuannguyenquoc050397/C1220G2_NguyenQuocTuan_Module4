package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;


    @GetMapping
    public ResponseEntity<List<Blog>> showListBlog(){
        List<Blog> blogList = blogRepository.findAll();
        if (blogList.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogRepository.save(blog), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
       Blog blog1 = blogRepository.findById(id).orElse(null);
        if (blog1== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blog1.getId());
        return new ResponseEntity<>(blogRepository.save(blog), HttpStatus.OK);
    }



}
