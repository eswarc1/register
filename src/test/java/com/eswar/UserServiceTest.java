package com.eswar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eswar.dao.daoImpl.UserDaoImpl;
import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.service.serviceImpl.UserServiceImpl;

public class UserServiceTest {
	private static final String EMAIL = "xyz@gmail.com";
	
	private User user;
	private List<User> users;
	
	@Mock 
	private UserDaoImpl daoMock;
	@InjectMocks
	private UserServiceImpl serviceImpl;
	
	@Before
	public void setup() throws Exception {
		
		this.user = Mockito.mock(User.class);
		this.users = Arrays.asList(user);
		Mockito.doReturn(EMAIL)
		.when(this.user)
		.getEmail();
		
		
		MockitoAnnotations.initMocks(this);
	
	}
	
	@Test
	public void findUsersTest() throws UserNotFoundException {
		
		
		 when(daoMock.findUsersFromDB()).thenReturn(users);
		
		 List<User> actualUsers = serviceImpl.findUsers();
		 
		 assertEquals(users,actualUsers);
		
	}
	
	@Test
	public void findUserByEmailTest() throws UserNotFoundException {
		
		when(daoMock.findUserByEmailFromDB(EMAIL)).thenReturn(user);
		
		 User actualUser = serviceImpl.findUserByEmail(EMAIL);
		 
		 assertEquals(user,actualUser);
		 
	}
	
	@Test
	public void createsUserTest() throws UserNotFoundException {
		
		
		when(daoMock.findUserByEmailFromDB(EMAIL)).thenReturn(user);
		
		 User actualUser = serviceImpl.findUserByEmail(EMAIL);
		 
		 assertEquals(user,actualUser);
		 
	}
	
	@Test
	public void deletesUserTest() throws UserNotFoundException {
	
		serviceImpl.removeUser(EMAIL);

		verify(daoMock).removeUserFromDB(EMAIL);
	
	}
	
}
		 