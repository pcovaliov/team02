package com.endava.endavainternship.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
	
	 public void validateImage(MultipartFile image);
	
	public void saveImage(String filename, MultipartFile image)
			throws RuntimeException, IOException;
}

