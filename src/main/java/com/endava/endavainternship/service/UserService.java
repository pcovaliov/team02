package com.endava.endavainternship.service;

import java.util.List;

import com.endava.endavainternship.entity.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(User user);
	
	public void removeUserByID(int userID);
	
	public User findUserById(Integer Id);
	
	public boolean updateUser(User user);
	
	public User findUserByEmail(String email);

}
