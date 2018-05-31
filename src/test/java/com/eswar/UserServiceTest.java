package com.eswar;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.repository.UserRepository;

import com.eswar.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	private User user;
	private List<User> users;
	
	@Mock 
	private UserRepository userRepositoryMock;
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setup() throws Exception {
		
		this.user = Mockito.mock(User.class);
		this.users = Arrays.asList(user);
		
		
		MockitoAnnotations.initMocks(this);
	
	}
	
	@Test
	public void findUsersTest() throws UserNotFoundException {
		
		
		 when(userRepositoryMock.findAll()).thenReturn(users);
		
		 List<User> actualUsers = userServiceImpl.findUsers();
		 
		 assertEquals(user,actualUsers.get(0));
		
	}
		
		
	}
