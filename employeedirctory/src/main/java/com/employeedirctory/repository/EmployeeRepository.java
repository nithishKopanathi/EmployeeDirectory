package com.employeedirctory.repository;

import java.util.List;

import com.employeedirctory.entity.Employee;

public interface EmployeeRepository  {
 
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
