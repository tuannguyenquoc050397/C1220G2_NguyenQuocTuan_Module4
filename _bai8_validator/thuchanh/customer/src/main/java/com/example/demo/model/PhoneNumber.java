package com.example.demo.model;

import com.example.demo.validator.CheckPhoneNumber;

import javax.validation.constraints.NotEmpty;

public class PhoneNumber {


    @CheckPhoneNumber
    private String number;

    public PhoneNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

