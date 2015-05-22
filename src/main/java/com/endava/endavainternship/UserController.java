package com.endava.endavainternship;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.TwitterService;
import com.endava.endavainternship.service.UserService;
//import com.endava.endavainternship.service.AvatarService;



@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private TwitterService twitterService;
	
	//@Autowired
	//private AvatarService avatarService;
	
	
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public String listUser(Model model) {
		
		Collection<User> userList = userService.listUser();
			
		model.addAttribute("userList", userList);
		
		int userNumber = userList.size();
		int pageNumber = (int)Math.ceil(userNumber/10.0);
		Map <Integer,List<User>> users = new HashMap <Integer,List<User>>();
		List l = new ArrayList<User>();
		
		int pageLimit = 10;
		int currentPage = 1;
		
		
		for(User u : userList){
			if(l.size() == pageLimit){
				users.put(currentPage, l);
				l=new ArrayList<User>();
				currentPage++;
			}
			l.add(u);
		}
		users.put(currentPage, l);
		
		model.addAttribute("userContainer",users);
		model.addAttribute("pageNumber", pageNumber );
		
		return "/user";
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(Map<String, Object> map) {
		System.out.println("------------------ " + logger.getClass() + " ------------------");
		map.put("user", new User());
		return "register";
	}
	
	
	@RequestMapping(value = "/register",  method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, 
			@RequestParam("image") MultipartFile image, BindingResult result,
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
		map.put("filePath", System.getProperty("catalina.home") + File.separator + "images" + File.separator);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/admin/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int userID) {
		userService.removeUserByID(userID);
		return "redirect:/user";
	}
	
	
	
	
	@RequestMapping(value="/admin/edit-user/{id}", method = RequestMethod.GET)
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
	
	
	
	@RequestMapping(value="/admin/edit-user/{id}", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/home/{id}", method = RequestMethod.GET)
	public String externalTweetsPage(
			Map<String, Object> map, 
			@PathVariable("id") int id, Model model
		) {
		
		User user = userService.findUserById(id);
		if(user == null){ //the id is not present in the db
			return "exception";
		}
		
		
		Collection<Tweet> tweetList = twitterService.getTweetsForUser(user);
		
		//
		int tweetNumber = tweetList.size();
		int pageNumber = (int)Math.ceil(tweetNumber/25.0);
		Map <Integer,List<Tweet>> tweets = new HashMap <Integer,List<Tweet>>();
		
		List l = new ArrayList<Tweet>();
		
		int pageLimit = 25;
		int currentPage = 1;
		
		for(Tweet t : tweetList){
			if(l.size() == pageLimit){
				tweets.put(currentPage, l);
				l = new ArrayList<Tweet>();
				currentPage++;
			}
			l.add(t);
		}
		tweets.put(currentPage, l);
		model.addAttribute("tweetContainer", tweets );
		model.addAttribute("pageNumber", pageNumber );
		model.addAttribute("currentUser", user );
		    
		return "/external-tweet-page";
	}
	


}
