package com.employeedirctory.service;

import java.util.List;

import com.employeedirctory.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
}
