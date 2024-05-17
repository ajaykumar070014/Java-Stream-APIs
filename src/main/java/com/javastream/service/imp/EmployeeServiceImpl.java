package com.javastream.service.imp;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.exception.ResourceNotFoundException;
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
    public List<EmployeeResponseDTO> getEmployeesGender(String gender) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTO= employeeRepository.findAll().stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTO.isEmpty()) {
            return employeeResponseDTO;
        } else {
            throw new ResourceNotFoundException(String.format("%s Gender is not found",gender));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTO = employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTO.isEmpty()) {
            return employeeResponseDTO;
        } else {
            throw new ResourceNotFoundException(String.format("%s Department not found",department));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByPosition(String position) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTOS =employeeRepository.findAll().stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase(position))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTOS.isEmpty()){
            return employeeResponseDTOS;
        }
        else{
            throw  new ResourceNotFoundException(String.format("%s Position not found",position));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByNameStartingWith(String prefix) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeRepository.findAll().stream()
                .filter(employee -> employee.getFirstName().toLowerCase().startsWith(prefix))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTOS.isEmpty()){
            return employeeResponseDTOS;
        }
        else{
            throw  new ResourceNotFoundException(String.format("%s did not match any existing data",prefix));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByCity(String city) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTOS =  employeeRepository.findAll().stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase(city))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTOS.isEmpty()){
            return employeeResponseDTOS;
        }
        else{
            throw  new ResourceNotFoundException(String.format("From %s state no employees exist ",city));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getEmployeesByState(String state) throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeRepository.findAll().stream()
                .filter(employee -> employee.getState().equalsIgnoreCase(state))
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTOS.isEmpty()){
            return employeeResponseDTOS;
        }
        else{
            throw  new ResourceNotFoundException(String.format("From %s state no employees exist ",state));
        }
    }

    @Override
    public List<EmployeeResponseDTO> getActiveEmployees() throws ResourceNotFoundException {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeRepository.findAll().stream()
                .filter(Employee::isActive)
                .map(EmployeeMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        if (!employeeResponseDTOS.isEmpty()){
            return employeeResponseDTOS;
        }
        else{
            throw  new ResourceNotFoundException("No employee in active status");
        }
    }
    @Override
    public EmployeeResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee= EmployeeMapper.INSTANCE.toEntity(employeeRequestDTO);
        employee= employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }

}
