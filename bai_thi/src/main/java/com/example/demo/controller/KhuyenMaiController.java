package com.example.demo.controller;


import com.example.demo.model.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
import com.example.demo.ulti.validate.KhuyenMaiValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KhuyenMaiController {

    @Autowired
    KhuyenMaiValidator khuyenMaiValidator;
    @Autowired
    KhuyenMaiService khuyenMaiService;

    
    @GetMapping("/khuyenmai")
    public ModelAndView showAll(@RequestParam(name = "mucGiamGia", required = false) Double mucGiamGia,
                                @RequestParam(name = "thoiGianBatDau", defaultValue = "") String thoiGianBatDau,
                                @RequestParam(name = "thoiGianKetThuc", defaultValue = "") String thoiGianKetThuc,
                                @PageableDefault(value = 3) Pageable pageable){
        Page<KhuyenMai> khuyenMais = khuyenMaiService.findSearch(
                mucGiamGia, thoiGianBatDau, thoiGianKetThuc, pageable
        );
        ModelAndView modelAndView = new ModelAndView("/khuyenmai/list");
        modelAndView.addObject("mucGiamGia", mucGiamGia);
        modelAndView.addObject("thoiGianBatDau", thoiGianBatDau);
        modelAndView.addObject("thoiGianKetThuc", thoiGianKetThuc);
        modelAndView.addObject("khuyenmais", khuyenMais);

        return modelAndView;
    }

    @GetMapping("/create-khuyenmai")
    public ModelAndView create() {
        return new ModelAndView("khuyenmai/create", "khuyenmai", new KhuyenMai());
    }

    @PostMapping("/create-khuyenmai")
    public ModelAndView createPost(@Validated @ModelAttribute("khuyenmai") KhuyenMai khuyenMai, BindingResult bindingResult
            , @PageableDefault(value = 3) Pageable pageable) {

        khuyenMaiValidator.validate(khuyenMai,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/khuyenmai/create", "khuyenmai", khuyenMai);
        }
        khuyenMaiService.save(khuyenMai);
        ModelAndView modelAndView = new ModelAndView("/khuyenmai/list");
        modelAndView.addObject("khuyenmais", khuyenMaiService.findAll(pageable));
        modelAndView.addObject("message", "them moi thanh cong");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        khuyenMaiService.deleteById(id);
        return "redirect:/khuyenmai";

    }

}
