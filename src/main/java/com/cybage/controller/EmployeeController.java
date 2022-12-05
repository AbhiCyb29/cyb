package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dao.IEmployeeDao;
import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@RestController

@RequestMapping("/employee")
public class EmployeeController 

{

	@Autowired
	EmployeeService empService;
	IEmployeeDao emprepo;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee)
	{
		empService.addEmployee(employee);
		return new ResponseEntity<String>("Employee added", HttpStatus.CREATED);
	}
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee>employees=empService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	@GetMapping("/getEmpById")
	public ResponseEntity<Employee> getEmpById(@PathVariable int id)
	{
		Employee employee = empService.getById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);			
	}
	@GetMapping("/getEmpByName")
	public ResponseEntity<List<Employee>> getEmpByName(@PathVariable String name)
	{
		List<Employee> employee = empService.findByName(name);
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	@DeleteMapping("/deleteEmpById/{id}")
	public ResponseEntity<String> deleteEmployee(int id)
	{
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}
	@PostMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(Employee employee)
	{
		empService.updateEmployee(employee);
		return new ResponseEntity<String>("Employee updated succesfully",HttpStatus.OK);
	}
	@GetMapping("/findByIdGreaterThan/{id}")
	public ResponseEntity <List<Employee>> findByIdGreaterThan(int id)
	{
		List<Employee> employee = empService.findByIdGreaterThan(id);
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.OK);
	}
	public ResponseEntity<List<Employee>> findByNameOrderByIdDesc(String name)
	{
		List<Employee> employees = empService.findByNameOrderByIdDesc(name);
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}	
}
