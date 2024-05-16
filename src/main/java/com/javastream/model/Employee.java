package com.javastream.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    private String employeeId;

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String country;
    private String department;
    private String position;
    private double salary;
    private int age;
    private Date startDate;

    private boolean isActive;
    @PrePersist
    public void generateId() {
        this.employeeId = UUID.randomUUID().toString();
    }
}
