package com.example.demo.controller;


import com.example.demo.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("counter")
public class CounterController {
    private static int count=0;
    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }
    @GetMapping("/")
    public ModelAndView get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        count++;
        return new ModelAndView("/index","counta",count);
    }
}
