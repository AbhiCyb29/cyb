package com.cybage.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.User;

public interface IUserDao extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	public List<User> findByIdGreaterThan(Long id);
	public List<User> findByUsernameOrderByIdDesc(String Username);
	boolean existsByEmail(String email);
	void save(Optional<User> user1);

}
