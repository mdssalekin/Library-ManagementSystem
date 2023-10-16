package com.shirajussalekin.lms.controllers;

import com.shirajussalekin.lms.dto.EmployeeDto;
import com.shirajussalekin.lms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id") long employeeId,
            @RequestBody EmployeeDto updatedEmployee){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, updatedEmployee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable("id") Long employeeId
    ) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
