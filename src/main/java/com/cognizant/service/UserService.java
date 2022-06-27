package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.entity.User;

public interface UserService {
	@Autowired
	public User createUser(User user) throws Exception;

	public User loginUser(String username, String password) throws Exception;

	public User getUser(String username);

	public void deleteUser(Long userId);

	// public User updateUser(String username);
}
