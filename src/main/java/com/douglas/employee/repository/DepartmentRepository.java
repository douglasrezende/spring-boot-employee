package com.douglas.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglas.employee.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
