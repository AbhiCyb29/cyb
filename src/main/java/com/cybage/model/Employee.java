package com.cybage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private int contactNo;
	private String city;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String address, int contactNo, String city) {
		super();
		id = id;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.city = city;
	}

	public int getId() {
		return id;
		
	}

	public void setId(int id) {
		id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + id + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", city="
				+ city + "]";
	}

}
