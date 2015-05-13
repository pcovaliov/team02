package com.endava.endavainternship.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.endava.endavainternship.entity.User;

public interface UserService {

	public void addUser(User user);

	public List<User> listUser();

	public void removeUser(User user);
	
	public void removeUserByID(int userID);
	
	public User findUserById(Integer Id);
	
	public boolean updateUser(User user);
	
	public User findUserByEmail(String email);
	
    public void validateImage(MultipartFile image);
	
	public void saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException;

}
