package com.eswar.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eswar.dao.UserDao;
import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserRepository repository;
	
	public List<User> findUsersFromDB() throws UserNotFoundException {
		
		List<User> users=repository.findAll();
		
		if(users!=null && users.size()>0)
		{
			return users;
		}
		else
		throw new UserNotFoundException("There are no users");
		
	}
		
		public User findUserByEmailFromDB(String email) throws UserNotFoundException {
			
			User users = repository.findByEmail(email);
			if(users.getEmail().equals(email)) {
				
				return users;
			
			}
			else
				throw new UserNotFoundException("No User Found with this id");
				 
		}


		public User saveUserToDB(User user) throws UserNotFoundException{

				repository.save(user);			
				
				return user;
		}
				
			

		public void removeUserFromDB(String email) throws UserNotFoundException {
			
			
			User userDB = repository.findByEmail(email);
			
			if(userDB==null) {
				throw new UserNotFoundException("No User to delete");
			}
				repository.deleteById(email);
		
			}


	}
