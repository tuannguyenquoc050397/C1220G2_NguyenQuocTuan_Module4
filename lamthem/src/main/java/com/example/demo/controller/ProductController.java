package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.ProductDetail;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductDetailService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductDetailService productDetailService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }


    @GetMapping
    public ModelAndView showProduct(@PageableDefault(value = 3) Pageable pageable) {

        return new ModelAndView("/product/list", "products",
                productService.findAll(pageable));
    }

    @GetMapping("/create-product")
    public ModelAndView createProduct() {
        return new ModelAndView("product/create",
                "product", new Product());
    }

    @PostMapping("/create-product")
    public ModelAndView createProduct(@PageableDefault(value = 3) Pageable pageable,
                                      Product product) {

        productService.save(product);
        return new ModelAndView("/product/list", "products",
                productService.findAll(pageable));
    }

    @GetMapping("/detail-product/{id}")
    public ModelAndView detailProduct(@PathVariable Long id) {

        return new ModelAndView("product/detail", "product",
                productService.findById(id));
    }
    @GetMapping("/delete-product/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {

        return new ModelAndView("product/delete", "product",
                productService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView deleteProduct(@RequestParam Long id,@PageableDefault(value = 3) Pageable pageable ){
        productService.deleteById(id);
        return new ModelAndView("/product/list", "products",
                productService.findAll(pageable));
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView editProduct(@PathVariable Long id) {

        return new ModelAndView("product/edit", "product",
                productService.findById(id));
    }
    @PostMapping("/edit")
    public ModelAndView editProduct(Product product,@PageableDefault(value = 3) Pageable pageable ){
        productService.save(product);

        return new ModelAndView("/product/list", "products",
                productService.findAll(pageable));

    }


}
