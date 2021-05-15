package com.example.demo.controller;


import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product== null) {
            return "/error.404";
        }
        if (action.equals("show+")) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        if (action.equals("show-")) {
            cart.subProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        Product product = productService.findById(id);

        return new ModelAndView("detail","product",product);
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}
