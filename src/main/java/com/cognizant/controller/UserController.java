package com.cognizant.controller;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.cognizant.entity.Role;
// import com.cognizant.entity.UserRole;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register/{role}")
	public User createUser(@RequestBody User req, @PathVariable("role") String role) throws Exception {
		System.out.println(req.toString());

		User user = new User();
		user.setUsername(req.getUsername());
		user.setPassword(req.getPassword());
		user.setFirstName(req.getFirstName());
		user.setLastName(req.getLastName());
		user.setEmail(req.getEmail());
		user.setPhone(req.getPhone());
		user.setEnabled(true);
		user.setRole(role);

		User user1 = this.userService.createUser(user);

		System.out.println(user1.toString());
		return user1;
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User req) throws Exception {
		return this.userService.loginUser(req.getUsername(), req.getPassword());
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	// delete by userId
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	// update database
	/*
	 * @PutMapping("/{username") public User updateUser(@PathVariable("username")
	 * String username) { return this.userService.updateUser(username); }
	 */
}
