package com.endava.endavainternship.service;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;
import com.endava.endavainternship.service.AvatarService;

@Service
public class AvatarServiceImpl implements AvatarService {

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
