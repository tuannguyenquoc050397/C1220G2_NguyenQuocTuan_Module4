package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.repository.ICustomerRepository;

import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;
    @Autowired
    private ICustomerRepository customerRepository;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAll();
    }


    @GetMapping("/create-customer")
    public ModelAndView create() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public ModelAndView createPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult
            , @PageableDefault(value = 3) Pageable pageable) {
        if (bindingResult.hasErrors()){
            return new ModelAndView("/customer/create","customer",customer);
        }
        customerService.save(customer);
        return new ModelAndView("/customer/list","customers", customerService.findAll(pageable) );
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ModelAndView("customer/404");
        }
        return new ModelAndView("customer/edit", "customer", customer);
    }

    @PostMapping("/edit-customer")
    public String editPost(@ModelAttribute("customer") Customer customer,
                           @PageableDefault(value = 3) Pageable pageable) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete-customer/{id}")
    public String delete(@PathVariable Integer id, @PageableDefault(value = 3) Pageable pageable) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    @GetMapping
    public ModelAndView search(@RequestParam(name = "name", defaultValue = "") String name,
                               @RequestParam(name = "dateOfBirth", defaultValue = "") String dateOfBirth,
                               @RequestParam(name = "typeCustomer", defaultValue = "") String typeCustomer,
                               @PageableDefault(value = 3) Pageable pageable) {
            Page<Customer> customerPage = customerService.findSearch(
                    name, dateOfBirth, typeCustomer, pageable
            );
            ModelAndView modelAndView = new ModelAndView("/customer/list");
            modelAndView.addObject("name", name);
            modelAndView.addObject("dateOfBirth", dateOfBirth);
            modelAndView.addObject("typeCustomer", typeCustomer);
            modelAndView.addObject("customers", customerPage);

            return modelAndView;
    }
    @GetMapping("/yc9")
    public ModelAndView searchYC9(@RequestParam(name = "name", defaultValue = "") String name,
                               @RequestParam(name = "dateOfBirth", defaultValue = "") String dateOfBirth,
                               @RequestParam(name = "typeCustomer", defaultValue = "") String typeCustomer,
                               @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findCs(
                name, dateOfBirth, typeCustomer, pageable
        );
        ModelAndView modelAndView = new ModelAndView("/customer/listYC9");
        modelAndView.addObject("name", name);
        modelAndView.addObject("dateOfBirth", dateOfBirth);
        modelAndView.addObject("typeCustomer", typeCustomer);
        modelAndView.addObject("customers", customerPage);
        return modelAndView;
    }
}
