package com.javastream.service;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEmployeesGender(String gender);
    List<EmployeeResponseDTO> getEmployeesByDepartment(String department);
    List<EmployeeResponseDTO> getEmployeesByPosition(String position);
    List<EmployeeResponseDTO> getEmployeesByNameStartingWith(String prefix);
    List<EmployeeResponseDTO> getEmployeesByCity(String city);
    List<EmployeeResponseDTO> getEmployeesByState(String state);
    List<EmployeeResponseDTO> getActiveEmployees();
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);
}
