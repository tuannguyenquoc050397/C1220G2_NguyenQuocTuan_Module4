package com.example.demo.controller;


import com.example.demo.model.Smartphone;
import com.example.demo.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/smartphones")
public class HomeController {

    @Autowired
    private SmartphoneService smartphoneService;


    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){

        Smartphone smartphone = smartphoneService.findById(id);

        return new ModelAndView("phones/edit","smartphone",smartphone);
    }

    @RequestMapping(value ="/edit-smartphone", method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone edit(@RequestBody Smartphone smartphone){
        return smartphoneService.save(smartphone);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphone = smartphoneService.findById(id);
        if (smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone, HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }

}
