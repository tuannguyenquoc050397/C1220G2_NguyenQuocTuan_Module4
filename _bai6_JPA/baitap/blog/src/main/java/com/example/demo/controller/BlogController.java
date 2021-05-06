package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView showListBlog(){

        return new ModelAndView("list","blogList",blogService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail( @PathVariable String id){

        return new ModelAndView("detail","blog",blogService.findById(Long.valueOf(id)));
    }

    @GetMapping("create")
    public ModelAndView createBlog(){
        return new ModelAndView("create","blog",new Blog());
    }
    @PostMapping("create")
    public ModelAndView createBlog(Blog blog){

        blogService.save(blog);
        return new ModelAndView("list","blogList",blogService.findAll());
    }
    @GetMapping("edit/{id}")
    public ModelAndView editBlog(@PathVariable Long id){

        return new ModelAndView("edit","blog",blogService.findById(id));
    }
    @PostMapping("edit")
    public ModelAndView editBlog(Blog blog){

        blogService.save(blog);
        return new ModelAndView("list","blogList",blogService.findAll());
    }
    @GetMapping("delete/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id) {
        blogService.deleteById(id);
        return new ModelAndView("list", "blogList", blogService.findAll());
    }
    }
