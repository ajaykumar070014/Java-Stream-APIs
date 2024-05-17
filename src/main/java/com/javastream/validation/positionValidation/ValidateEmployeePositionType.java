package com.javastream.validation.positionValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateEmployeePositionTypeIml.class)
public @interface ValidateEmployeePositionType {
    public String message() default "Invalid Position Entered : Backend Developer, Data Scientist, Frontend Developer, System Architect, Marketing Manager, Market Research Analyst, HR Manager, HR Business Partner";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
