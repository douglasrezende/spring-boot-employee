package com.douglas.employee.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.douglas.employee.model.Employee;

public class EmployeeDto {
	private Integer id;
	private String name;
	private LocalDateTime creationDate;


	public EmployeeDto(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.creationDate = LocalDateTime.now();
	}


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public static List<EmployeeDto> convert(List<Employee> employees) {
		return employees.stream().map(EmployeeDto::new).collect(Collectors.toList());
	}


}
