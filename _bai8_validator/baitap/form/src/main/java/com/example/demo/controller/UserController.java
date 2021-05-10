package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/")
    public ModelAndView formUser(){
    return new ModelAndView("index", "user",new User());
    }

    @PostMapping("/")
    public ModelAndView checkValidate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("index","user",user);
        }else {
            return new ModelAndView("result");
        }
    }
}
