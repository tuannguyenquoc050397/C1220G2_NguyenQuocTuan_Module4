package com.example.demo.controller;


import com.example.demo.model.Bill;
import com.example.demo.model.Category;
import com.example.demo.model.ProductBill;
import com.example.demo.service.*;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductDetailService productDetailService;
    @Autowired
    BillService billService;
    @Autowired
    ProductBillService productBillService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView showBill(@PageableDefault(value = 3) Pageable pageable) {

        return new ModelAndView("/bill/list", "bills",
                billService.findAll(pageable));
    }

    @GetMapping("/detail-bill/{id}")
    public ModelAndView detailBill(@PathVariable Long id) {
        Bill bill = billService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/bill/detail");
        modelAndView.addObject("bill",bill);
        modelAndView.addObject("productsInBill",productBillService.findByBill(bill));
        return modelAndView;

    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String searchName, @RequestParam String searchCost,
                               @RequestParam String searchDate){
        List<ProductBill> list =
                productBillService.findByBill_DateAndProductNameContainingAndProduct_ProductDetail_Cost(
                        searchDate,searchName,Double.parseDouble(searchCost)
                );

        List<Bill> bills = new ArrayList<>();

        for (ProductBill productBill : list) {
            bills.add(productBill.getBill());
        }
        return new ModelAndView("/bill/list", "bills",
               bills);


    }
}
