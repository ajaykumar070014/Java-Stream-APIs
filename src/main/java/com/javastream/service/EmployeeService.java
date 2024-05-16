package com.javastream.service;

import com.javastream.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getFemaleEmployees();
    List<Employee> getMaleEmployees();
    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getEmployeesByPosition(String position);
    List<Employee> getEmployeesByNameStartingWith(String prefix);
    List<Employee> getEmployeesByCity(String city);
    List<Employee> getEmployeesByState(String state);
    List<Employee> getActiveEmployees();
    Employee addEmployee(Employee employee);
}
