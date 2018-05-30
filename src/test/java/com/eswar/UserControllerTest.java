package com.eswar;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.eswar.entities.User;
import com.eswar.controller.UserController;
import com.eswar.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	UserService service = mock(UserService.class);
	
	@InjectMocks
	private UserController controller;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();
	}
	
	@Test
	public void testGetTest() throws Exception{
		
		User user = new User();
		List<User> users = new ArrayList<User>();
		users.add(user);
		when(service.findUsers()).thenReturn(users);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/users/")
				)
		        .andExpect(MockMvcResultMatchers.status().isOk());
		        
		     
	}
	

}