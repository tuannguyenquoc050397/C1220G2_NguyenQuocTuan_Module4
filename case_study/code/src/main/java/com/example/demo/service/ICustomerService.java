package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(Integer id);
    void deleteById(Integer id);
    Page<Customer> findSearch(String name, String dateOfBirth, String customerType, Pageable pageable);
}
