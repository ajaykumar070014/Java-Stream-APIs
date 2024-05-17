package com.javastream.service.imp;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.mapper.EmployeeMapper;
import com.javastream.model.Employee;
import com.javastream.repository.EmployeeRepository;
import com.javastream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeResponseDTO> getEmployeesGender(String gender) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByPosition(String position) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase(position))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByNameStartingWith(String prefix) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getFirstName().toLowerCase().startsWith(prefix))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByCity(String city) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase(city))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByState(String state) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getState().equalsIgnoreCase(state))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getActiveEmployees() {
        return employeeRepository.findAll().stream()
                .filter(Employee::isActive)
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee= EmployeeMapper.INSTANCE.toEntity(employeeRequestDTO);
        employee= employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }

}
