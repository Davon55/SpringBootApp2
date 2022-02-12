package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.SearchUsersModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/users")
public class UsersControllerForPages {
	// uses dependency injection configuration found in the SpringConfig file 
		// to choose which busienssService will be utilized.
		@Autowired
		private UsersBusinessServiceInterface usersService;
		
//		@GetMapping("/spa") 
//		public String displaySPA(Model model)
//		{
//			// Display single page application
//			model.addAttribute("title", "Orders");
//			model.addAttribute("searchOrdersModel", new SearchOrdersModel());
//			return "ordersSPA";
//		}
		

		@GetMapping("/searchForm") 
		public String displaySearchForm(Model model)
		{
			// Display Login Form View
			model.addAttribute("title", "Search Orders");
			model.addAttribute("searchUsersModel", new SearchUsersModel());
			return "userSearchForm";
		}
		
		@GetMapping("/addNewForm") 
		public String displayAddNewForm(Model model)
		{
			// Display new order form
			model.addAttribute("title", "Add new order");
			model.addAttribute("UserModel", new UserModel());
			return "usersAddNewForm";
		}
		
		@PostMapping("/searchResults") 
		public String showAllOrders(@Valid SearchUsersModel searchModel, BindingResult bindingResult, Model model) { 
			System.out.println("Performing search results for " + searchModel.getSearchTerm());
			// Check for validation errors
	        if (bindingResult.hasErrors()) 
	        {
	        	model.addAttribute("title", "Search for Users");
	            return "usersSearchForm";
	        }
			List<UserModel> users = usersService.searchUsers(searchModel.getSearchTerm());  
		 	model.addAttribute("title", "Search for Users");
			model.addAttribute("searchModel", searchModel);
			model.addAttribute("users", users);
			
			return "users";
			
		}
		@GetMapping("/all") 
		public String showAllUsers( Model model) { 
			 
			List<UserModel> users = usersService.getUsers();  
		 	model.addAttribute("title", "Show all users");
			model.addAttribute("searchModel", new SearchUsersModel());
			model.addAttribute("users", users);
			
			return "users";
			
		}
		
		@PostMapping("/addNew") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String addUser(@Valid UserModel newUser, BindingResult bindingResult, Model model) {
			// add the new order
			usersService.addOne(newUser);
			
			// get updated list of all the orders
			List<UserModel> users = usersService.getUsers(); 
			
			// display all orders
			model.addAttribute("users", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "users";
		}
		 
		
		
		@GetMapping("/admin") 
		public String showUsersForAdmin( Model model) { 
			 
			// display all orders with delete and edit buttons
			List<UserModel> users = usersService.getUsers();  
		 	model.addAttribute("title", "Edit or delete users");
			model.addAttribute("searchModel", new SearchUsersModel());
			model.addAttribute("users", users);
			
			// ordersAdmin page shows a table of orders including buttons for del and edit.
			return "usersAdmin";
			
		}
		
		@PostMapping("/delete") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String deleteUser(@Valid UserModel order, BindingResult bindingResult, Model model) {
			// add the new order
			usersService.deleteOne(order.getId());
			
			// get updated list of all the orders
			List<UserModel> users = usersService.getUsers(); 
			
			// display all orders
			model.addAttribute("users", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "usersAdmin";
		}
		
		@PostMapping("/editForm") 
		public String displayEditForm(UserModel userModel, Model model)
		{
			// Display new order form
			model.addAttribute("title", "Edit users");
			model.addAttribute("userModel", userModel);
			return "usersEditForm";
		}
		
		@PostMapping("/doUpdate") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String updateUser(@Valid UserModel user, BindingResult bindingResult, Model model) {
			// add the new order
			usersService.updateOne(user.getId(), user);
			
			// get updated list of all the orders
			List<UserModel> users = usersService.getUsers(); 
			
			// display all orders
			model.addAttribute("users", users); 
			model.addAttribute("searchModel", new SearchUsersModel()); 
			return "usersAdmin";
		}



}
