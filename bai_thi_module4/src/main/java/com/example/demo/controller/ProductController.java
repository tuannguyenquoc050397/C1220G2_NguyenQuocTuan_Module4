package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public List<Category> categories(){
      return categoryService.findAll();
    }

    @GetMapping("/product")
    public ModelAndView showAll(@RequestParam(name = "name", defaultValue = "") String name,
                                @RequestParam(name = "cost",required = false) Integer cost,
                                @RequestParam(name = "category", defaultValue = "") String category,
                                @PageableDefault(value = 3)
                                @SortDefault(sort = "cost" , direction = Sort.Direction.ASC)Pageable pageable){
        Page<Product> products = productService.findSearch(
                name, cost, category, pageable
        );
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("name", name);
        modelAndView.addObject("cost", cost);
        modelAndView.addObject("category", category);
        modelAndView.addObject("products", products);

        return modelAndView;
    }
    @GetMapping
    public String home(){
        return "home";
    }

//    @GetMapping("/cost")
//    public ModelAndView cost(@PageableDefault(value = 3)
//                             @SortDefault(sort = "cost" , direction = Sort.Direction.ASC) Pageable pageable){
//    return new ModelAndView("product/list","products",productService.findAll(pageable));
//    }
    @GetMapping("/create-product")
    public ModelAndView create() {
        return new ModelAndView("product/create", "product", new Product());
    }

    @PostMapping("/create-product")
    public ModelAndView createPost(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult
            , @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/product/create", "product", product);
        }
        productService.save(product);
        return new ModelAndView("/product/list","products",productService.findAll(pageable));
    }
    @GetMapping("/edit-product/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if(product == null){
            return new ModelAndView("/product/404", "id", id);
        }

        return new ModelAndView("/product/edit", "product", product);
    }

    @PostMapping("/edit-product")
    public ModelAndView editPost(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult
            , @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/product/edit", "product", product);
        }
        productService.save(product);
        return new ModelAndView("/product/list","products",productService.findAll(pageable));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        productService.deleteById(id);
        return "redirect:/product";

    }
}
