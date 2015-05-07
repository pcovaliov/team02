package com.endava.endavainternship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.dao.UserDAO;
import com.endava.endavainternship.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
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
		
		return userDAO.listUser();
	}

	@Override
	@Transactional
	public void removeUser(User user) {
		
		userDAO.removeUser(user);
		
	}

	@Override
	@Transactional
	public void removeUserByID(int userID) {
		User u = userDAO.findUserById(userID);
		if(u != null){
			userDAO.removeUser(u);
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
		return userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
	

}
