package com.shirajussalekin.lms.dao;

import com.shirajussalekin.lms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
