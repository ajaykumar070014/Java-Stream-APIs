package com.javastream.validation.positionValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ValidateEmployeePositionTypeIml implements ConstraintValidator<ValidateEmployeePositionType,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        List<String> employeePositionType = Arrays.asList("Backend Developer","Data Scientist","Frontend Developer","System Architect","Marketing Manager","Market Research Analyst","HR Manager","HR Business Partner");
        return employeePositionType.contains(value);
    }
}
