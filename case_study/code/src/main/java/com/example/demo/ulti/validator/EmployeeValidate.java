package com.example.demo.ulti.validator;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class EmployeeValidate implements Validator {
    @Autowired
    IEmployeeService employeeService;
    private static final String REGEX="^[A-Za-z0-9]+[@][a-z]+\\.[a-z]+$";
    Pattern pattern;


    @Override
    public boolean supports(Class<?> clazz){
        return Employee.class.isAssignableFrom(clazz);
    }
    @Override
        public void validate(Object o, Errors errors){
        Employee employee = (Employee) o;
        pattern= Pattern.compile(REGEX);

        if (employee.getId() != null){
            if (employeeService.existsEmployeeByEmailAndIdNot(employee.getEmail(),employee.getId())
                || !pattern.matcher(employee.getEmail()).matches()){
                errors.rejectValue("email", "validate.email");
            }
        }else {
            if (employeeService.existsEmployeeByEmail(employee.getEmail())
            || !pattern.matcher(employee.getEmail()).matches() ){
                errors.rejectValue("email", "validate.email");
            }
        }
    }

}
