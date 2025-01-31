package com.ems.service.impl;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(int id) {

        Employee employee=   employeeRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Employee does not exits with this Id"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
        // check that employee is existing in database with corresponding id
       Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exists with this Id"+id));
       
       // Update employee
        employee.setFirstName(employeeDto.getFirstName());
        employee.getLastName();
        employee.getEmail();
       Employee employeeUpdated= employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(employeeUpdated);
        
    }

    @Override
    public void DeleteEmployee(int id) {
        // check if employee is existing in database to corresponding ID
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exists for this Id"+id));
        
        // delete employee
        employeeRepository.deleteById(id);
    }
}
