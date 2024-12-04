package com.example.EMS.DAO;

import java.util.List;

import com.example.EMS.Entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);// insert or update 
	
	public void deleteById(int id);
}
