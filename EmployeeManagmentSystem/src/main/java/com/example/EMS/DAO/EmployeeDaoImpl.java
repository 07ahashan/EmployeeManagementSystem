package com.example.EMS.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.EMS.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{	
	
	@Autowired	
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll(){
		TypedQuery<Employee> query = entityManager.createQuery(" from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}
	
	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}
	
	@Override
	@Transactional
	public Employee save(Employee employee){
		Employee dbEmployee = entityManager.merge(employee);
		return dbEmployee;
	}
	
	@Override
	@Transactional
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}
	
}

