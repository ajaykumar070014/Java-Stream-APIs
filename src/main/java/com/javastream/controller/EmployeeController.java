package com.javastream.controller;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.exception.ResourceNotFoundException;
import com.javastream.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{gender}")
    public List<EmployeeResponseDTO>getEmployeesGender(@PathVariable String gender) throws ResourceNotFoundException {
        return employeeService.getEmployeesGender(gender);
    }
    @GetMapping("/department/{department}")
    public List<EmployeeResponseDTO>getEmployeesByDepartment(@PathVariable String department) throws ResourceNotFoundException {
        return employeeService.getEmployeesByDepartment(department);
    }
    @GetMapping("/position/{position}")
    public List<EmployeeResponseDTO>getEmployeesByPosition(@PathVariable String position) throws ResourceNotFoundException {
        return employeeService.getEmployeesByPosition(position);
    }
    @GetMapping("/prefix/{prefix}")
    public List<EmployeeResponseDTO> getEmployeesByNameStartingWith(@PathVariable String prefix) throws ResourceNotFoundException {
        return employeeService.getEmployeesByNameStartingWith(prefix);
    }

    @GetMapping("/city/{city}")
    public List<EmployeeResponseDTO>getEmployeesByCity(@PathVariable String city) throws ResourceNotFoundException {
        return employeeService.getEmployeesByCity(city);
    }
    @GetMapping("/active")
    public List<EmployeeResponseDTO>getActiveEmployees() throws ResourceNotFoundException {
        return employeeService.getActiveEmployees();
    }
    @GetMapping("/state/{state}")
    public List<EmployeeResponseDTO>getEmployeesByState(@PathVariable String state) throws ResourceNotFoundException {
        return employeeService.getEmployeesByState(state);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody @Valid EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO createdEmployee = employeeService.addEmployee(employeeRequestDTO);
        return ResponseEntity.ok(createdEmployee);
    }

}
