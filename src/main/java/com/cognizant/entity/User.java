package com.cognizant.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean enabled = true;
	private String role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userFk")
	@JsonIgnore
	private Set<Lending> lendings = new HashSet<>();

	public User() {
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email,
			String phone, boolean enabled, String role, Set<Lending> lendings) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.role = role;
		this.lendings = lendings;
	}

	@Override
	public String toString() {
		return "{" +
				" id='" + id + "'" +
				", username='" + username + "'" +
				", password='" + password + "'" +
				", firstName='" + firstName + "'" +
				", lastName='" + lastName + "'" +
				", email='" + email + "'" +
				", phone='" + phone + "'" +
				", enabled='" + enabled + "'" +
				", role='" + role + "'" +
				"}";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Lending> getLendings() {
		return this.lendings;
	}

	public void setLendings(Set<Lending> lendings) {
		this.lendings = lendings;
	}

}
