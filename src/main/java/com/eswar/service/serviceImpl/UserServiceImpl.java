package com.eswar.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eswar.dao.UserDao;
import com.eswar.entities.User;
import com.eswar.exceptions.UserNotFoundException;
import com.eswar.repository.UserRepository;
import com.eswar.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	
	public List<User> findUsers() throws UserNotFoundException {
	
		return dao.findUsersFromDB();
	}

	
	public User findUserByEmail(String email) throws UserNotFoundException {
		
		return dao.findUserByEmailFromDB(email);
	}

	
	public User saveUser(User user) throws UserNotFoundException {
		
		return dao.saveUserToDB(user);
	}

	@Override
	public void removeUser(String email) throws UserNotFoundException {
		
		dao.removeUserFromDB(email);
	}

//	@Autowired
//	UserRepository repository;
//	
//	public List<User> findUsers() throws UserNotFoundException{
//		
//		List<User> users=repository.findAll();
//		
//		if(users!=null && users.size()>0)
//		{
//			return users;
//		}
//		else
//		throw new UserNotFoundException("There are no users");
//	}
//
//	public User findUserByEmail(String email) throws UserNotFoundException {
//		
//		User users = repository.findByEmail(email);
//		if(users.getEmail().equals(email)) {
//			
//			return users;
//		
//		}
//		else
//			throw new UserNotFoundException("No User Found with this id");
//			 
//	}
//
//
//	public User createsUser(User user) throws UserNotFoundException{
//
//			repository.save(user);			
//			
//			return user;
//	}
//			
//		
//
//	public void deletesUser(String email) throws UserNotFoundException {
//		
//		
//		User userDB = repository.findByEmail(email);
//		
//		if(userDB==null) {
//			throw new UserNotFoundException("No User to delete");
//		}
//			repository.deleteById(email);
//			return;
//	
//		}


}
