package com.endava.endavainternship.dao;

import java.util.List;

import com.endava.endavainternship.entity.User;


public interface UserDAO {
	
	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(User user);
		
	public User findUserById(Integer id);
	
	public User findUserByEmail(String email);

	public boolean updateUser(User user);
}
