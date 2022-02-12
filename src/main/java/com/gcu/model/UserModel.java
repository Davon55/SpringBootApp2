package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
	private int Id;
//	@NotNull(message="First Name required")
//	@Size(min=1, max=77, message="Must be between 1 & 77 characters")
	private String firstName;
//	@NotNull(message="Last Name required")
//	@Size(min=1, max=77, message="Must be between 1 & 77 characters")
	private String lastName;
	@NotNull(message="Username required")
	@Size(min=1, max=77, message="Must be between 1 & 77 characters")
	private String username;
	@NotNull(message="Password required")
	@Size(min=1, max=77, message="Must be between 1 & 77 characters")
	private String password;
//	@NotNull(message="Email required")
//	@Size(min=1, max=77, message="Must be between 1 & 77 characters")
	private String Email;
	
	public UserModel(int Id,String firstname, String lastname, String username, String password, String Email) {
		
		this.Id = Id;
		this.firstName = firstname;
		this.lastName = lastname;
		this.username = username;
		this.password = password;
		this.Email = Email;
	}

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastName;
	}
	
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
}