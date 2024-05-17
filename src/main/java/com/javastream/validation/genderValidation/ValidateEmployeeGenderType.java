package com.javastream.validation.genderValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateEmployeeGenderTypeImpl.class)
public @interface ValidateEmployeeGenderType {
    public String message() default "Invalid Gender Entered : Male,Female";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
