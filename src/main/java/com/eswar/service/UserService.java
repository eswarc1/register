package com.eswar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;

@Service
public interface UserService {
	
	public List<User> findUsers() throws UserNotFoundException;
	
	public User findUserByEmail(String email) throws UserNotFoundException;
	
	public User saveUser(User user) throws UserNotFoundException;
	
	public void removeUser(String email) throws UserNotFoundException;


}
