package com.ems.controller;

import com.ems.dto.EmployeeDto;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    // Get employee By Id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") int id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }
    // Get List of employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeDto> employees=employeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }
    
    // Update Employee By Id
    @PutMapping("{id}")
    public ResponseEntity updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee=employeeService.updateEmployee(id,employeeDto);
        if(updatedEmployee!=null){
            return ResponseEntity.ok(updatedEmployee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    // Delete employee by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        employeeService.DeleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
        
}
