package com.ems.service;

import com.ems.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    
    // create a employee
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    // Get employee by Id
    public EmployeeDto getEmployeeById(int id);
    
    // Get list of employees
    public List<EmployeeDto> getEmployees();
    
    // update employee
    public EmployeeDto updateEmployee(int id,EmployeeDto employeeDto);
    
    // Delete employee
    public void DeleteEmployee(int id);
    
    
}
