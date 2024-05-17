package com.javastream.service;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEmployeesGender(String gender) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getEmployeesByDepartment(String department) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getEmployeesByPosition(String position) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getEmployeesByNameStartingWith(String prefix) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getEmployeesByCity(String city) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getEmployeesByState(String state) throws ResourceNotFoundException;
    List<EmployeeResponseDTO> getActiveEmployees() throws ResourceNotFoundException;
    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO);
}
