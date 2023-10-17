package com.shirajussalekin.lms.mappers;

import com.shirajussalekin.lms.dto.EmployeeDto;
import com.shirajussalekin.lms.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getGender(),
                employee.getContactNo(),
                employee.getDateOfBirth(),
                employee.getCreationDateTime(),
                employee.getRole(),
                employee.getArticles()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee (
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getGender(),
                employeeDto.getContactNo(),
                employeeDto.getDateOfBirth(),
                employeeDto.getJoiningDateTime(),
                employeeDto.getRole(),
                employeeDto.getArticles()
        );
    }
}
