package controllers;

import model.service.impl.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import model.service.DictionaryService;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;


    @GetMapping()
    public String change(Model model){
        return "home";
    }

    @GetMapping("/dictionary")
    public String change(Model model, @RequestParam String inputWord){
        model.addAttribute("word", dictionaryService.findWord(inputWord));
        return "home";
    }

}
