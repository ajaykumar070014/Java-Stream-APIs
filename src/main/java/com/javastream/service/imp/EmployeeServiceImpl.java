package com.javastream.service.imp;

import com.javastream.model.Employee;
import com.javastream.repository.EmployeeRepository;
import com.javastream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getFemaleEmployees() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("female"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getMaleEmployees() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("male"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByPosition(String position) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase(position))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByNameStartingWith(String prefix) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getFirstName().toLowerCase().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByCity(String city) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByState(String state) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getActiveEmployees() {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.isActive())
                .collect(Collectors.toList());
    }
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
