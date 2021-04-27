package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {


    @GetMapping()
    public String change(Model model){
        return "home";
    }

    @GetMapping("/dictionary")
    public String change(Model model, @RequestParam String inputWord){
         Map<String, String> wordMap = new HashMap<>();
            wordMap.put("hello1","xin chao1");
            wordMap.put("hello2","xin chao2");
            wordMap.put("hello3","xin chao3");
            wordMap.put("hello4","xin chao4");
            wordMap.put("hello5","xin chao5");
        model.addAttribute("word", wordMap.get(inputWord));
        return "home";
    }

}
