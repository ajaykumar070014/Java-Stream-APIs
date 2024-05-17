package com.javastream.controller;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.model.Employee;
import com.javastream.service.EmployeeService;
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
    public List<EmployeeResponseDTO>getEmployeesGender(@PathVariable String gender){
        return employeeService.getEmployeesGender(gender);
    }
    @GetMapping("/department/{department}")
    public List<EmployeeResponseDTO>getEmployeesByDepartment(@PathVariable String department){
        return employeeService.getEmployeesByDepartment(department);
    }
    @GetMapping("/position/{position}")
    public List<EmployeeResponseDTO>getEmployeesByPosition(@PathVariable String position){
        return employeeService.getEmployeesByPosition(position);
    }
    @GetMapping("/prefix/{prefix}")
    public List<EmployeeResponseDTO> getEmployeesByNameStartingWith(@PathVariable String prefix) {
        return employeeService.getEmployeesByNameStartingWith(prefix);
    }

    @GetMapping("/city/{city}")
    public List<EmployeeResponseDTO>getEmployeesByCity(@PathVariable String city){
        return employeeService.getEmployeesByCity(city);
    }
    @GetMapping("/active")
    public List<EmployeeResponseDTO>getActiveEmployees(){
        return employeeService.getActiveEmployees();
    }
    @GetMapping("/state/{state}")
    public List<EmployeeResponseDTO>getEmployeesByState(@PathVariable String state){
        return employeeService.getEmployeesByState(state);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        EmployeeResponseDTO createdEmployee = employeeService.addEmployee(employeeRequestDTO);
        return ResponseEntity.ok(createdEmployee);
    }
}
