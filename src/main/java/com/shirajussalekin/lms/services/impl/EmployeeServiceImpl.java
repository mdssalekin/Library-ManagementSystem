package com.shirajussalekin.lms.services.impl;

import com.shirajussalekin.lms.dao.EmployeeRepository;
import com.shirajussalekin.lms.dto.EmployeeDto;
import com.shirajussalekin.lms.entities.Employee;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.mappers.EmployeeMapper;
import com.shirajussalekin.lms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return EmployeeMapper
                .mapToEmployeeDto(employeeRepository
                        .save(EmployeeMapper
                                .mapToEmployee(employeeDto)));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return EmployeeMapper
                .mapToEmployeeDto(employeeRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("The Employee does not exist by given ID!!")));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(
                        employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        if (!employeeRepository.existsById(id))
            throw new ResourceNotFoundException("The Employee does not exist by given ID!!");

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getGender(),
                employeeDto.getContactNo(),
                employeeDto.getDateOfBirth(),
                employeeDto.getJoiningDateTime(),
                employeeDto.getRoles(),
                employeeDto.getArticles()
                );
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id))
            throw new ResourceNotFoundException("The Employee does not exist by given ID!!");
        employeeRepository.deleteById(id);
    }
}
