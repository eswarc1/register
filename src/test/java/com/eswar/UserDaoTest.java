package com.eswar;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.eswar.dao.daoImpl.UserDaoImpl;
import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;

//@SpringBootTest(classes = {H2TestConfig.class})
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserDaoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDaoImpl daoImpl;
	
	@Before
	public void init() {
		
		user.setEmail("eswar1@gmail.com");
		user.setFirstName("Eswar");
		user.setLastName("Chilukuri");
		user.setPassword("1234");
		user.setPhoneNumber("1234567890");
		entityManager.persist(user);
		entityManager.flush();
		
	}

	@Test
	public void findUsersFromDBTest() throws UserNotFoundException {
	
	List<User> fromDB = daoImpl.findUsersFromDB();
	
	assertEquals(fromDB.get(0).getEmail(),"eswar1@gmail.com");
		
	}
	
	@Test
	public void findUserByEmailFromDBTest() throws UserNotFoundException {
	
	User fromDB = daoImpl.findUserByEmailFromDB(user.getEmail());
	
	assertEquals(user.getEmail(),fromDB.getEmail());
		
	}
	
	@Test
	public void saveUserToDBTest() throws UserNotFoundException {
	
	User fromDB = daoImpl.saveUserToDB(user);
	
	assertEquals(user.getEmail(),fromDB.getEmail());
		
	}
	
	@Test
	public void removeUserFromDBTest() throws UserNotFoundException {
	
	daoImpl.removeUserFromDB(user.getEmail());
	
	assertEquals(user,null);
		
	}
	
		
	
		
	
	
	
	
}
