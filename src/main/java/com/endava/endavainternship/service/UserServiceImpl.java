package com.endava.endavainternship.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.dao.UserDAO;
import com.endava.endavainternship.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
		
	}

	@Override
	@Transactional
	public List<User> listUser() {
		
		try{
			
		logger.info("User saved to database");
		return userDAO.listUser();
		
		}
		catch(Exception e){
			logger.error("ERROR : Can not save user to database");
			return null;
		}
		
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		try{
			logger.info("User deleted " + user);
		    userDAO.removeUser(user);	
	}
		catch (Exception e){
			
			logger.error("ERROR : Can not delete user" + user);
			
		}
		
	}

	@Override
	@Transactional
	public void removeUserByID(int userID) {
		
		try{
		User u = userDAO.findUserById(userID);
		if(u != null){
			logger.info("User deleted " + u);
			userDAO.removeUser(u);
			
		}
		}
		catch(Exception e){
			logger.error("Cannot remove user by ID ");
			
		}
		
	}

	@Override
	@Transactional
	public User findUserById(Integer Id) {
		return userDAO.findUserById(Id);
		
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		System.out.println("*******1");
		try{
			System.out.println("*******2");
			logger.info("User was updated : " + user);
			boolean updateResult = userDAO.updateUser(user);
			System.out.println("*******"+updateResult);
		return  updateResult;
		}
		catch(Exception e){System.out.println("*******3");
			logger.error("ERROR : Updating user " + user);
			return false;
		}
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
}
