package com.javastream.mapper;

import com.javastream.constants.GlobalConstants;
import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.model.Employee;

public class EmployeeMapperImpl implements EmployeeMapper{
    @Override
    public Employee toEntity(EmployeeRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFirstName( dto.getFirstName() );
        employee.setLastName( dto.getLastName() );
        employee.setGender( dto.getGender() );
        employee.setEmail( dto.getEmail() );
        employee.setPhoneNumber( dto.getPhoneNumber() );
        employee.setAddress( dto.getAddress() );
        employee.setCity( dto.getCity() );
        employee.setState( dto.getState() );
        employee.setCountry(GlobalConstants.COUNTRY);
        employee.setDepartment( dto.getDepartment() );
        employee.setPosition( dto.getPosition() );
        employee.setSalary( dto.getSalary() );
        employee.setAge( dto.getAge() );
        employee.setStartDate( dto.getStartDate() );
        employee.setActive(true);

        return employee;
    }

    @Override
    public EmployeeResponseDTO toDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();

        employeeResponseDTO.setFirstName( employee.getFirstName() );
        employeeResponseDTO.setLastName( employee.getLastName() );
        employeeResponseDTO.setGender( employee.getGender() );
        employeeResponseDTO.setDepartment( employee.getDepartment() );
        employeeResponseDTO.setPosition( employee.getPosition() );
        return employeeResponseDTO;
    }
}
