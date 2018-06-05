package com.eswar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.repository.UserRepository;

@Repository
public interface UserDao {
	
		public List<User> findUsersFromDB() throws UserNotFoundException;
		
	
		
		public User findUserByEmailFromDB(String email) throws UserNotFoundException;
		


		public User saveUserToDB(User user) throws UserNotFoundException;

			

		public void removeUserFromDB(String email) throws UserNotFoundException;
			
}
