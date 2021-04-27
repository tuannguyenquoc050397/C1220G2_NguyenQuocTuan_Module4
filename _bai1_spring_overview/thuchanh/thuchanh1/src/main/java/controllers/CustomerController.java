package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/greeting")
    public String greeting(){
        return "home";
    }
}
