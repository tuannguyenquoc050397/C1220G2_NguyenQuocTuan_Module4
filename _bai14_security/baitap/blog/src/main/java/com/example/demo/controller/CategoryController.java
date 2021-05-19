package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView showListCategory(@PageableDefault(value = 3) Pageable pageable){

        return new ModelAndView("category/list","categoryList", categoryService.findAll(pageable));
    }

    @GetMapping("create")
    public ModelAndView createCategory(){
        return new ModelAndView("category/create","category",new Category());
    }
    @PostMapping("create")
    public ModelAndView createCategory(Category category,@PageableDefault(value = 3) Pageable pageable){

        categoryService.save(category);
        return new ModelAndView("category/list","categoryList", categoryService.findAll(pageable));
    }
    @GetMapping("edit/{id}")
    public ModelAndView editCategory(@PathVariable Long id){

        return new ModelAndView("category/edit","category", categoryService.findById(id));
    }
    @PostMapping("edit")
    public ModelAndView editCategory(Category category, @PageableDefault(value = 3) Pageable pageable){

        categoryService.save(category);
        return new ModelAndView("category/list","CategoryList", categoryService.findAll(pageable));
    }
    @GetMapping("delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id, @PageableDefault(value = 3) Pageable pageable) {
        categoryService.deleteById(id);
        return new ModelAndView("category/list", "CategoryList", categoryService.findAll(pageable));
    }
    @GetMapping("showPost/{id}")
    public ModelAndView showPost(@PathVariable Long id,@PageableDefault(value = 3) Pageable pageable ){
        Page<Blog> blogList = blogService.findAllByCategory_Id(id, pageable);
        ModelAndView modelAndView =new ModelAndView("category/showPost");
        modelAndView.addObject("blogList",blogList);
        modelAndView.addObject("id",id);
        return modelAndView;

    }

}
