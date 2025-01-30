package com.ems.service;

import com.ems.dto.EmployeeDto;
import org.springframework.stereotype.Service;


public interface EmployeeService {
    
    // create a employee
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    
}
