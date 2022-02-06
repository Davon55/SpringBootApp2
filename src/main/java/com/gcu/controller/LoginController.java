package com.gcu.controller;

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
public class LoginController {
	
	
	
	@GetMapping("/")
	public String display(Model model)
	{
		//display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	}
	 
	@PostMapping("/doLogin")
	public String doLogin(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		
		//check for validation error 
		if(bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		model.addAttribute("userModel", userModel);
		model.addAttribute("searchModel", new SearchUsersModel());
		return "users";
		
	}
}