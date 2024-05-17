package com.javastream.validation.departmentValidation;

import com.javastream.validation.departmentValidation.ValidateEmployeeDepartmentTypeImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidateEmployeeDepartmentTypeImpl.class)
public @interface ValidateEmployeeDepartmentType {
    public String message() default "Invalid Department Entered : Development, Marketing, Human Resources";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
