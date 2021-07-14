package com.example.demo.dto;

import com.example.demo.model.*;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class EmployeeDto implements Validator {

    private static final String REGEX="^[A-Za-z0-9]+[@][a-z]+\\.[a-z]+$";
    Pattern pattern;
    private int id;

    @NotBlank
    private String name;

    private String dateOfBirth;
    private String idCard;

    private double salary;
    private String phone;

    private String email;

    private String address;

    private Position position;

    private EducationDegree educationDegree;


    private Division division;


    private User user;

    private List<Contract> contracts;

    public EmployeeDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Autowired
    IEmployeeService employeeService;

    @Override
    public boolean supports(Class<?> clazz){
        return Employee.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object o, Errors errors){
        EmployeeDto employeeDto = (EmployeeDto) o;
        pattern= Pattern.compile(REGEX);
        List<Employee> employees = employeeService.findAll();
        boolean checkEmail = false;
        for (Employee employee : employees) {
            if (employeeDto.getEmail().equals(employee.getEmail())) {
                checkEmail = true;
                break;
            }
        }
        if (checkEmail || !pattern.matcher(employeeDto.getEmail()).matches()) {
            errors.rejectValue("email", "validate.email");
        }


    }

}
