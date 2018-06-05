package com.eswar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService service;

	@GetMapping("/")
	public List<User> getUsers() throws UserNotFoundException {
		
			List<User> users= service.findUsers();
			return users;
		
	}
	

	@GetMapping("/user/{email}")
	public User getUserByEmail(@PathVariable String email) throws UserNotFoundException {
		
		User user = service.findUserByEmail(email);

			return user; 
	}
	
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) throws UserNotFoundException {
	
			service.saveUser(user);	
			
			return user;
	}
		

		
	@DeleteMapping("/user/{email}")
	public void deleteUser(@PathVariable String email) throws UserNotFoundException {
		
			service.removeUser(email);
	
		}


}
