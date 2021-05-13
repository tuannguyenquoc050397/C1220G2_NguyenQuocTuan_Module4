package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }



    @GetMapping
    public ModelAndView showListBlog(@PageableDefault(value = 3) Pageable pageable
            ,@RequestParam("search") Optional<String> search){

        Page<Blog> blogList;
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if (search.isPresent()){
            blogList = blogService.findAllByNameContaining(search.get() , pageable);

            modelAndView.addObject("blogList", blogList);
            modelAndView.addObject("searchController", search.get());

        }else {
            blogList = blogService.findAll(pageable);
            modelAndView.addObject("blogList", blogList);
        }

        return modelAndView;
    }


    @GetMapping("detail/{id}")
    public ModelAndView showDetail( @PathVariable String id){
        try {
            Optional<Blog> blog = blogService.findById(Long.valueOf(id));
            return new ModelAndView("blog/detail","blog", blog.get());
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("blog/error");

        }

    }

//    @GetMapping("create")
//    public ModelAndView createBlog(){
//        return new ModelAndView("blog/create","blog",new Blog());
//    }
//
//    @PostMapping("create")
//    public ModelAndView createBlog(Blog blog, @PageableDefault(value = 3) Pageable pageable){
//        blogService.save(blog);
//        return new ModelAndView("blog/list","blogList",blogService.findAll(pageable));
//    }
//    @GetMapping("edit/{id}")
//    public ModelAndView editBlog(@PathVariable Long id){
//
//        return new ModelAndView("blog/edit","blog",blogService.findById(id));
//    }
//    @PostMapping("edit")
//    public ModelAndView editBlog(Blog blog,@PageableDefault(value = 3) Pageable pageable){
//
//        blogService.save(blog);
//        return new ModelAndView("blog/list","blogList",blogService.findAll(pageable));
//    }
//    @GetMapping("delete/{id}")
//    public ModelAndView deleteBlog(@PathVariable Long id, @PageableDefault(value = 3) Pageable pageable) {
//        blogService.deleteById(id);
//        return new ModelAndView("blog/list", "blogList", blogService.findAll(pageable));
//    }
    }
