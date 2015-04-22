package com.endava.twitter.dao;
import java.util.List;

import com.endava.twitter.entity.User;


public interface UserDAO {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(User user);
	
	public void updateUser(User user);
	
	public void findById(User user);
}

