package com.endava.endavainternship;

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
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/register")
	public String registerUser(Map<String, Object> map) {
		System.out.println("------------------ " + logger.getClass() + " ------------------");

		map.put("user", new User());
//		map.put("userList", userService.listUser());

		return "register";
	}
	
//	@RequestMapping("/register1")
//	public ModelAndView registerUser1(Map<String, Object> map) {
//		System.out.println("------------------ " + logger.getClass() + " ------------------");
//        ModelAndView template = new ModelAndView("template");
//        template.addObject("data", "register");
//		map.put("user", new User());
//		map.put("userList", userService.listUser());
//
//		return template;
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			Map<String, Object> map ) {
		
		if(result.hasErrors()){
			System.out.println("error on user validation");
			return "/login";			
		}
		System.out.println(user);
		userService.addUser(user);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/";
	}
	
	
	@RequestMapping(value="/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int userID) {
		userService.removeUserByID(userID);
		System.out.println(userID);
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
			System.out.println("2lalalalalalalal");
			return "user";
		}
		if(userService.updateUser(user) == true){
			return "redirect:/user";
		} else {
			map.put("errorMessage", "User not found in the db");
			return "/exception";
		}
	}
	
	
	
	
	
	
	
	
	

}
