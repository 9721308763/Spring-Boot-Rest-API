package com.ems.service.impl;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        System.out.println(employeeDto);
        Employee employeeSaved=employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
        return  EmployeeMapper.mapToEmployeeDto(employeeSaved);
    }
}
