package com.endava.twitter.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.endava.twitter.entity.User;
import com.endava.twitter.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public String listUsers(Map<String, Object> map) {
		System.out.println("------------------ " + logger.getClass() + " ------------------");

		map.put("user", new User());
		map.put("usersList", userService.listUser());

		return "/user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		userService.addUser(user);

		return "redirect:/user";

	}

}
