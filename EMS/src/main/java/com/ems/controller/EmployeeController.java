package com.ems.controller;

import com.ems.dto.EmployeeDto;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    // Build Add employee REST API
    @GetMapping("/hi")
    public String sayHello(){
        return "Hello world";
    }
    @PostMapping("/add")
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        System.out.println(employeeDto);
       EmployeeDto employeeSaved=employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
    }
}
