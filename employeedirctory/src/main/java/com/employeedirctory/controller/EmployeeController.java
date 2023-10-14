package com.employeedirctory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeedirctory.entity.Employee;
import com.employeedirctory.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	//printing employee list on the browser
	@GetMapping("/list")
	public String list(Model theModel) {
		List<Employee> theEmployee = employeeService.findAll();
		theModel.addAttribute("employee",theEmployee);
		return "employee-list";
	}
	
	//show employee form to add employee
    @GetMapping("/addEmployee")
    public String addEmployee(Model theModel) {
    	Employee theEmployee = new Employee();
    	theModel.addAttribute("employee",theEmployee);
    	return "employee-form";
    }
    
    //saving and updating the new employee or existing employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
    	//save the employee
    	 employeeService.save(employee);
    	 // redirect to prevent duplicate submissions
    	 return "redirect:/employee/list";
    	 }
    
    //updating the employee
    @GetMapping("/update")
    public String update(@RequestParam ("employeeId") int theId,Model theModel) {
    	Employee theEmployee= employeeService.findById(theId);
    	theModel.addAttribute("employee",theEmployee);
    	return "employee-form";
    }
    
    //delete the employee 
    @GetMapping("/delete")
    public String delete(@RequestParam ("employeeId") int theId) {
    	 employeeService.deleteById(theId);
    	 return "redirect:/employee/list";
    }
}
