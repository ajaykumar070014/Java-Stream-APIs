package com.javastream.dto;

import com.javastream.validation.departmentValidation.ValidateEmployeeDepartmentType;
import com.javastream.validation.genderValidation.ValidateEmployeeGenderType;
import com.javastream.validation.positionValidation.ValidateEmployeePositionType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
@Data
public class EmployeeRequestDTO {
    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be Blank")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Gender cannot be null")
    @ValidateEmployeeGenderType
    private String gender;

    @Email
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;

    @NotNull(message = "Address cannot be null")
    private String address;

    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "State cannot be null")
    private String state;
    private String country;

    @NotNull(message = "Department cannot be null")
    @ValidateEmployeeDepartmentType
    private String department;

    @NotNull(message = "Gender cannot be null")
    @ValidateEmployeePositionType
    private String position;

    @NotNull(message = "Gender cannot be null")
    private double salary;

    @Min(18)
    @Max(60)
    @NotNull(message = "Age cannot be null")
    private int age;

    @NotNull(message = "stateDate cannot be null")
    private Date startDate;

    private boolean isActive;
}
