package com.douglas.employee.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.douglas.employee.model.Department;
import com.douglas.employee.model.Employee;
import com.douglas.employee.repository.DepartmentRepository;
import com.douglas.employee.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		Department dept = departmentRepository.findById(employee.getDepartment().getId())
				.orElse(null);
		if (null == dept) {
			dept = new Department();
		}
		dept.setDeptName(employee.getDepartment().getDeptName());
		employee.setDepartment(dept);
		return employeeRepository.save(employee);
	}
	
	public Employee editEmployees(Employee entity) {
		return employeeRepository.save(entity);
	}
	
	public void deleteEmployees(Integer id) {
		employeeRepository.deleteById(id);
	}
}
