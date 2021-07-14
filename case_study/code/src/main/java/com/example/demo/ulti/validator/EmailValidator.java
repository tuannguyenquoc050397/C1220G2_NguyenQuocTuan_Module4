package com.example.demo.ulti.validator;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements ConstraintValidator<EmailVip, String> {

    @Autowired
    IEmployeeService employeeService;
    private static final String REGEX="^[A-Za-z0-9]+[@][a-z]+\\.[a-z]+$";
    Pattern pattern;

    @Override
    public void initialize(EmailVip constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        pattern=Pattern.compile(REGEX);
        List<Employee> employees = employeeService.findAll();
        boolean checkEmail = false;
        for (Employee employee : employees) {
            if (value.equals(employee.getEmail())) {
                checkEmail = true;
                break;
            }
        }
        return !checkEmail && pattern.matcher(value).matches();
    }
}
