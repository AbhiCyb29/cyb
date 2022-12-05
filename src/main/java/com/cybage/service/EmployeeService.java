package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.dao.IEmployeeDao;
import com.cybage.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	IEmployeeDao empRepo; 
	
	public Employee addEmployee(Employee employee)
	{
		return empRepo.save(employee);
	}
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	public Employee getById(int id)
	{
		return empRepo.findById(id).orElse(null);
	}
	public List<Employee> findByName(String name)
	{
		return empRepo.getByName(name);
	}
	
	public void deleteEmployee(int id)
	{
		empRepo.deleteById(id);
	}
	public void updateEmployee(	Employee employee)
	{
		empRepo.save(employee);
	}
	public List<Employee> findByIdGreaterThan(int id)
	{
		return empRepo.findByIdGreaterThan(id);
	}
	public List<Employee> findByNameOrderByIdDesc(String name)
	{
		return empRepo.findByNameOrderByIdDesc(name);
	}

}
