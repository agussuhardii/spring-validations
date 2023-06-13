package com.agussuhardi.springvalidation.costumevalidation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author agus.suhardii@gmail.com
 * @created 13/06/23/06/2023 :21.25
 * @project spring-validation
 */
public class RegisterCodeConstraintsImpl implements ConstraintValidator<RegisterCodeConstraints, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return value.equals("123456");
    }
}