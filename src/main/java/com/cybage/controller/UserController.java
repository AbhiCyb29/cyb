package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dao.IUserDao;
import com.cybage.model.User;
import com.cybage.service.UserDetailsServiceImpl;

@RestController

@RequestMapping("/user")
public class UserController 

{

	@Autowired
	UserDetailsServiceImpl userService;
	IUserDao userRepo;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return new ResponseEntity<String>("User added", HttpStatus.CREATED);
	}
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getUsers(){
		List<User>users=userService.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user = userService.getById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);			
	}
	@GetMapping("/getUserByName")
	public ResponseEntity<List<User>> getEmpByName(@PathVariable String name)
	{
		Optional<User> user = userService.findByUsername(name);
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> deleteUser(Long id)
	{
		userService.deleteUser(id);
		return new ResponseEntity<String>("User deleted", HttpStatus.OK);
	}
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateEmployee(User user)
	{
		userService.updateEmployee(user);
		return new ResponseEntity<String>("User updated succesfully",HttpStatus.OK);
	}
	@GetMapping("/findByIdGreaterThan/{id}")
	public ResponseEntity <List<User>> findByIdGreaterThan(Long id)
	{
		List<User> user = userService.findByIdGreaterThan(id);
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	public ResponseEntity<List<User>> findByNameOrderByIdDesc(String username)
	{
		List<User> user = userService.findByUsernameOrderByIdDesc(username);
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}	
}
