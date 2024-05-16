package com.javastream.controller;

import com.javastream.model.Employee;
import com.javastream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/female")
    public List<Employee>getFemaleEmployees(){
        return employeeService.getFemaleEmployees();
    }
    @GetMapping("/male")
    public List<Employee>getMaleEmployees(){
        return employeeService.getMaleEmployees();
    }
    @GetMapping("/department/{department}")
    public List<Employee>getEmployeesByDepartment(@PathVariable String department){
        return employeeService.getEmployeesByDepartment(department);
    }
    @GetMapping("/position/{position}")
    public List<Employee>getEmployeesByPosition(@PathVariable String position){
        return employeeService.getEmployeesByPosition(position);
    }
    @GetMapping("/prefix/{prefix}")
    public List<Employee> getEmployeesByNameStartingWith(@PathVariable String prefix) {
        return employeeService.getEmployeesByNameStartingWith(prefix);
    }

    @GetMapping("/city/{city}")
    public List<Employee>getEmployeesByCity(@PathVariable String city){
        return employeeService.getEmployeesByCity(city);
    }
    @GetMapping("/active")
    public List<Employee>getActiveEmployees(){
        return employeeService.getActiveEmployees();
    }
    @GetMapping("/state/{state}")
    public List<Employee>getEmployeesByState(@PathVariable String state){
        return employeeService.getEmployeesByState(state);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
