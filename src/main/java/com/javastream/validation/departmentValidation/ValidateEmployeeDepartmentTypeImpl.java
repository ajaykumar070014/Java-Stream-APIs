package com.javastream.validation.departmentValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidateEmployeeDepartmentTypeImpl implements ConstraintValidator<ValidateEmployeeDepartmentType,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> employeeDepartmentType = Arrays.asList("Development","Marketing","Human Resources");
        return employeeDepartmentType.contains(value);
    }
}
