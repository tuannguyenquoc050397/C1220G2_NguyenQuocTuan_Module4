package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidate implements ConstraintValidator<CheckPhoneNumber,String> {

    private static final String REGEX="[0-9]{10}";
    Pattern pattern;

    @Override
    public void initialize(CheckPhoneNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        pattern=Pattern.compile(REGEX);

        return pattern.matcher(value).matches();
    }
}
