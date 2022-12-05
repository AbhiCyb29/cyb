package com.cybage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.model.User;
import com.cybage.dao.IUserDao;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
  @Autowired
	IUserDao userRepo;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

  
  //mymethods 
  public void addUser(User user) {
		userRepo.save(user);
		
	}

	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	public User getById(Long id)
	{  
		return userRepo.findById(id).orElse(null);
	}
	public Optional<User> findByUsername(String username)
	{
		return userRepo.findByUsername(username);
	}
	
	public void deleteUser(	Long id)
	{
		userRepo.deleteById(id);
	}
	public void updateEmployee(	User user)
	{
		userRepo.save(user);
	}
	public List<User> findByIdGreaterThan(Long id)
	{
		return userRepo.findByIdGreaterThan(id);
	}
	public List<User> findByUsernameOrderByIdDesc(String Username)
	{
		return userRepo.findByUsernameOrderByIdDesc(Username);
	}

}
