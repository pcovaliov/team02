package com.endava.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.twitter.dao.UserDAO;
import com.endava.twitter.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional
	public List<User> listUser() {

		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(User user) {
		userDAO.removeUser(user);
	}
	
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
}
