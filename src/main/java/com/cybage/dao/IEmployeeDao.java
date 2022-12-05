package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Employee;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Integer>{
	public List<Employee> getByName(String name);
	public String getById(int id);
	public List<Employee> findByIdGreaterThan(int id);
	public List<Employee> findByNameOrderByIdDesc(String name);
	

}
