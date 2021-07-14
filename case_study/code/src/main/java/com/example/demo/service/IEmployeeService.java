package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    void deleteById(Integer id);
    void save(Employee employee);
    Employee findById(Integer id);
    Boolean existsEmployeeByEmail(String email);
    Boolean existsEmployeeByEmailAndIdNot(String email , Integer id);
}
