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
public class SandwichController {
    @GetMapping("/")
    public String test(Model model){
        return "index";

    }
    @PostMapping("/sandwich")
    public ModelAndView save(@RequestParam(name="sandwich1", required = false, defaultValue = "") String sandwich1) {


        String result = "Sandwich vip pro has condiments: " +sandwich1;

        return new ModelAndView("success","result",result);
    }
}
