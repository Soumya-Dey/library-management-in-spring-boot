package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByUsername(String username);

	//public User updateByUsername(String username);

	

}
