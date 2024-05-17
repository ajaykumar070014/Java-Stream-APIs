package com.javastream.validation.genderValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidateEmployeeGenderTypeImpl implements ConstraintValidator<ValidateEmployeeGenderType,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> employeeDepartmentType = Arrays.asList("Male","Female");
        return employeeDepartmentType.contains(value);
    }
}
