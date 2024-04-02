package com.refresh.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refresh.entities.User;
import com.refresh.service.UserService;

@RestController
@RequestMapping("/jwt")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		System.out.println("GETTING USER");
		return this.userService.getUser();
	}
	
	@GetMapping("/current")
	public String loggedInUser(Principal principal)
	{
		return principal.getName();
	}
	
	
}
