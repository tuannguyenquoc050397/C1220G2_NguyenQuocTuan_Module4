package com.example.demo.model;


import com.example.demo.ulti.validator.EmailVip;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @Size(min = 5, max =45)
    @NotBlank
    private String firstName;

    @Size(min = 5, max =45)
    @NotBlank
    private String lastName;

    @EmailVip
    private String email;

    @Min(18)
    private int age;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
