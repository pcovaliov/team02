package com.endava.endavainternship.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.endava.endavainternship.UserController;
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
		try{
		User u = userDAO.findUserById(userID);
		if(u != null){
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
		return userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}
	
	@Override
	public void validateImage(MultipartFile image) {
		if ((!image.getContentType().equals("image/jpg")) || (!image.getContentType().equals("image/png")) ) {
			throw new RuntimeException("Only JPG and PNG images are accepted");
		}
	}

	@Override
	public void saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException {
		
		try {
			      
			String filePath = System.getProperty("catalina.home") + File.separator + "webapps" + File.separator +"ROOT"+ File.separator +"images" + File.separator;
			System.out.println("FILE:"+filePath);
			File file = new File(filePath + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out
					.println("Go to the location:  "
							+ file.toString()
							+ " on your computer and verify that the image has been stored.");
		} catch (IOException e) {
			throw e;
		}	
	}
}
