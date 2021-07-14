package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Boolean existsEmployeeByEmail(String email);
    Boolean existsEmployeeByEmailAndIdNot(String email , Integer id);

}
