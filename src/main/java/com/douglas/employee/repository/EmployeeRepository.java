package com.douglas.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
