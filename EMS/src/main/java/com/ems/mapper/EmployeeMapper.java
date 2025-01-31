package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

public class EmployeeMapper {

    // Method to convert Jpa entity to employeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(),employee.getLastName(),employee.getEmail());
        return employeeDto;
    }

    // Method to convert EmployeeDto to Jpa entity(Employee)
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
        return employee;
    }
}