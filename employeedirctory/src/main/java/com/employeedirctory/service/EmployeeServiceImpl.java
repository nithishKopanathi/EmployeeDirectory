package com.employeedirctory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedirctory.entity.Employee;
import com.employeedirctory.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	
	public Employee findById(int theId) {
		 Employee employee = employeeRepository.findById(theId);
		 if(employee==null) {
			 throw new RuntimeException("Employee not found of id"+theId);
		 }
		 return employee;
	}

	@Transactional
	public void save(Employee theEmployee) {
            employeeRepository.save(theEmployee);		
	}

	@Transactional
	public void deleteById(int theId) {
		Employee employee = employeeRepository.findById(theId);
		 if(employee==null) {
			 throw new RuntimeException("Employee not found of id"+theId);
		 }
	    employeeRepository.deleteById(theId);
	}

}
