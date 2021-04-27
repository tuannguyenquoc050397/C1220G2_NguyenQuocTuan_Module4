package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    @GetMapping()
    public String change(Model model){
        return "home";
    }

    @PostMapping("/chuyentien")
    public String change(Model model, @RequestParam String usd){
        Double vnd = Double.parseDouble(usd)*23000;
        model.addAttribute("vnd", vnd);
        return "home";
    }

}
