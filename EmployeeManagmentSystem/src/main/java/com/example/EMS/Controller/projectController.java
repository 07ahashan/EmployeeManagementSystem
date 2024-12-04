package com.example.EMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EMS.Entity.Employee;
import com.example.EMS.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class projectController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/Employee")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
	@GetMapping("/Employee/{employeeId}")
	public Employee getEmployee(@PathVariable int EmployeeId) {
		return employeeService.findById(EmployeeId);
	}
	
	@PostMapping("/Employee")
	public Employee AddEmployee(@RequestBody Employee employee) {
		Employee employeeDB =  employeeService.save(employee);	
		return employeeDB;
	}
	
	@PutMapping("/Employee")
	public Employee UpdateEmployee(@RequestBody Employee employee) {
		Employee employeeDB = employeeService.save(employee);
		return employeeDB;
	}
	
	@DeleteMapping("/Employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId ) {
		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee == null) {
			throw new RuntimeException("EmployeeId not found" + employeeId);
		}else {
			employeeService.deleteById(employeeId);
		}
		
		return "EmployeeId  "  + employeeId + "  got deleted";
	}
	
	
	
}
