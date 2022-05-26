package com.douglas.employee.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.douglas.employee.controller.dto.EmployeeDto;
import com.douglas.employee.model.Employee;
import com.douglas.employee.service.EmployeeService;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/get-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody Employee employee, UriComponentsBuilder uriBuilder) {
		Employee emp = employeeService.addEmployee(employee);

		URI uri = uriBuilder.path("/{id}").buildAndExpand(emp.getId()).toUri();
		//		return ResponseEntity.created(uri).body(new TopicoDto(topico));

		//new TopicoDto(topico)
		return ResponseEntity.created(uri).body(new EmployeeDto(emp));

		//return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.editEmployees(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteEmployee(@RequestParam(name = "employeeId") 
	Integer employeeId) {
		employeeService.deleteEmployees(employeeId);
		return new ResponseEntity<>("Employee with ID :" + employeeId 
				+ " deleted successfully", HttpStatus.OK);
	}
}
