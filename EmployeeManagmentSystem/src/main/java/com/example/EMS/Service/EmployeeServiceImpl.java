package com.example.EMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EMS.DAO.EmployeeDao;
import com.example.EMS.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}
}
