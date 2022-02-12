package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.UserModel;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	@Autowired
	private UsersBusinessServiceInterface userService;
	
	
	
	
	@GetMapping("/")
	public List<UserModel> showAllUsers(Model model) {
	
		return userService.getUsers();
	}
	@GetMapping("/{id}")
	public UserModel getOne(@PathVariable(name="id") int id) {
		return userService.getByID(id);
		
	}
	@GetMapping("/search/{searchTerm}")
    public List<UserModel> searchUser(@PathVariable(name="searchTerm") String searchTerm){
    	return userService.searchUsers(searchTerm);
    }
	@PostMapping("/")
	public UserModel addUser(@RequestBody UserModel addUser) {
		userService.addOne(addUser);
		return addUser;
	}
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable(name="id") int id) {
		return userService.deleteOne(id);
	}
	@PutMapping("/")
	public UserModel updateUser(@RequestBody UserModel updateUser) {
		return userService.updateOne(updateUser.getId(), updateUser);
	}
}
