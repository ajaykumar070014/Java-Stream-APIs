package com.javastream.mapper;

import com.javastream.dto.EmployeeRequestDTO;
import com.javastream.dto.EmployeeResponseDTO;
import com.javastream.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);
    Employee toEntity(EmployeeRequestDTO dto);
    EmployeeResponseDTO toDTO(Employee employee);
}
