package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String test(Model model) {
        return "index";
    }
    @GetMapping("/calculator")
    public ModelAndView calculator(@RequestParam(name="number1", required = false, defaultValue = "0") double number1,
                             @RequestParam(name="number2", required = false, defaultValue = "0") double number2,
                             @RequestParam String actionClient,
                             Model model){
        double result=0;

        switch (actionClient){

            case "add":
                result=number1+number2;
                break;
            case "sub":
                result=number1-number2;
                break;
            case "mul":
                result=number1*number2;
                break;
            case "div":
                result=number1/number2;
                break;
        }


        model.addAttribute("result",result);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("s","ssssssssss");
//        modelAndView.addObject("a","aaaaaaaaa");
        modelAndView.setViewName("index");
        return modelAndView;


    }
}
