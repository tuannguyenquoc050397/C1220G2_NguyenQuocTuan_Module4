package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class BlogController {

    private static int count = 2;
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView showList(){
        count =2;
        return new ModelAndView("list", "blogs", blogService.findLimit(2));
    }


    @GetMapping("/search-blog/{searchName}")
    @ResponseBody
    public ModelAndView search(@PathVariable String searchName ){
        List<Blog> blogList = blogService.findAllByNameContaining(searchName);

        return new ModelAndView("searchList", "blogs",
                blogList);
    }
    @GetMapping("/xemthem")
    @ResponseBody
    public ModelAndView xemthem(){
        count +=2;
        return new ModelAndView("xemthemList", "blogs",
                blogService.findLimit(count));
    }
    }
