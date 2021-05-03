package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("")
    public ModelAndView index(){

        return new ModelAndView("/index","products",productService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/create","product",new Product());
    }

    @PostMapping("/save")
    public ModelAndView save(Product product){
        productService.save(product);
        return new ModelAndView("/index","products",productService.findAll());
    }
    @GetMapping("{id}/update")
    public ModelAndView update(@PathVariable String id){
        Product product = productService.findById(id);
        return new ModelAndView("/update","product",product);
    }
    @PostMapping("/update")
    public ModelAndView update(Product product){
        productService.update(product.getId(),product);
        return new ModelAndView("/index","products",productService.findAll());
    }

    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable String id ){
        return new ModelAndView("/delete","product",productService.findById(id));

    }

    @PostMapping("/delete")
    public ModelAndView delete(Product product ){
        productService.remove(product.getId());

        return new ModelAndView("/index","products",productService.findAll());

    }


}
