package com.endava.endavainternship;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.UserService;


@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/user")
	public String listUser(Map<String, Object> map) {
		System.out.println("------------------ " + logger.getClass() + " ------------------");

		map.put("userList", userService.listUser());
		
		System.out.println(userService.listUser().size());

		return "/user";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(Map<String, Object> map) {
		System.out.println("------------------ " + logger.getClass() + " ------------------");

		map.put("user", new User());
//		map.put("userList", userService.listUser());

		return "register";
	}
	
	
	@RequestMapping(value = "/register",  method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, 
			@RequestParam MultipartFile image, BindingResult result,
			Map<String, Object> map ) {
		System.out.println(user.getFirstname() + user.getLastname() + ".jpg");

		if(result.hasErrors()){
			
			logger.debug("user registration failed");
			return "/login";			
		}
		if (!image.isEmpty()) {

				//userService.validateImage(image);
				user.setImageName(user.getFirstname() + user.getLastname() + ".jpg");
				try {
					userService.saveImage(user.getImageName(),	image);
				} catch (IOException e) {
					result.reject(e.getMessage());
					return "/login";
				}
			} else {
				user.setImageName("user.png");
			}
		logger.info("Added user:" + user.getFirstname());
		userService.addUser(user);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int userID) {
		userService.removeUserByID(userID);
		return "redirect:/user";
	}
	
	
	
	
	@RequestMapping(value="/edit-user/{id}", method = RequestMethod.GET)
	public String editUser(Map<String, Object> map ,@PathVariable("id") int id) {
		User u = userService.findUserById(id);
		if(u != null){
			System.out.println(u);
			map.put("user", u);
			return "/edit-user";
		} else {
			map.put("errorMessage", "User not found in the db");
			return "/exception";
		}
	}
	
	
	
	@RequestMapping(value="/edit-user/{id}", method = RequestMethod.POST)
	public String editUserAction(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Map<String, Object> map) {
		if (bindingResult.hasErrors()){
			logger.error("An error has occured to update user ");
			return "user";
		}
		if(userService.updateUser(user) == true){
			return "redirect:/user";
		} else {
			logger.error("User not found in the db");
			//map.put("errorMessage", "User not found in the db");
			return "/exception";
		}
	}
	
	
	
	
	
	
	
	
	

}
