package com.example.demo.ulti.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<EmailVip, String> {

    private static final String REGEX="^[A-Za-z0-9]+[@][a-z]+\\.[a-z]+$";
    Pattern pattern;

    @Override
    public void initialize(EmailVip constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        pattern=Pattern.compile(REGEX);
        return pattern.matcher(value).matches();
    }
}
