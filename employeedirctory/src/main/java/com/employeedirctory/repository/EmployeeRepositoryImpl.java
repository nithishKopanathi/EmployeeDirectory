package com.employeedirctory.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employeedirctory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//find List of employees
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query=entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	//find Employee based on employee id
	@Override
	public Employee findById(int theId) {
		return entityManager.find(Employee.class, theId);

	}

	//saving and updating the new and existing employee
	@Override
	public void save(Employee theEmployee) {
		Employee emp =  entityManager.merge(theEmployee);
		
	}

	//delete the employee based on the employee id
	@Override
	public void deleteById(int theId) {
		Employee emp =  entityManager.find(Employee.class, theId);
	       entityManager.remove(emp);
	}

}
