package com.cognizant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.User;
import com.cognizant.repo.UserRepository;
import com.cognizant.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) throws Exception {
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("Username already exits!");
			throw new Exception("Username already exits!");
		} else {

			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User loginUser(String username, String password) throws Exception {
		User user = this.userRepository.findByUsername(username);
		if (user == null || !user.getPassword().equals(password))
			throw new Exception("Username or password wrong!");

		return user;
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
}
