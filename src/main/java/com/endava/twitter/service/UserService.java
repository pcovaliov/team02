package com.endava.twitter.service;

import java.util.List;

import com.endava.twitter.entity.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(User user);
	
	public void updateUser(User user);
}
