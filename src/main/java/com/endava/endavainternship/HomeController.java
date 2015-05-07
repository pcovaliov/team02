package com.endava.endavainternship;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.TwitterService;
import com.endava.endavainternship.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	TwitterService twitterService;
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection tweetList = twitterService.getTweetsForUser(currentUser);
		model.addAttribute("tweetObject", new Tweet() );
		model.addAttribute("tweetList", tweetList );
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public String addTweet(@Valid @ModelAttribute("tweetObject") Tweet insertedTweet, BindingResult bindingResult,Map<String, Object> map) {
		if(bindingResult.hasErrors()){
			return "home";	
		}
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		insertedTweet.setUser(currentUser);
		twitterService.addTweet(insertedTweet);
		
		
		return "redirect:/";
	}
	
	
	
	
}
