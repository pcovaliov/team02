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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.TwitterService;
import com.endava.endavainternship.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	TwitterService twitterService;
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
			   @RequestParam(value = "limit", required = false, defaultValue = "10") int limit
			  ) {
		
		logger.info("logging starts");
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection tweetList = twitterService.getTweetsForUser(currentUser, limit, offset);
		model.addAttribute("tweetObject", new Tweet() );
		model.addAttribute("tweetList", tweetList );
		
		
		
		return "home";
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public String addTweet(@Valid @ModelAttribute("tweetObject") Tweet insertedTweet, BindingResult bindingResult,Map<String, Object> map) {
		if(bindingResult.hasErrors()){
			return "home";	
		}
		
		System.out.println("ololo"+insertedTweet.getTweet());
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		insertedTweet.setUser(currentUser);
		twitterService.addTweet(insertedTweet);
		
		
		return "redirect:/";
	}
	
	@ResponseBody @RequestMapping(value = "/testing-tweet" , method = RequestMethod.POST)
	public String addTweetJson(@Valid @ModelAttribute("tweetObject") Tweet insertedTweet, BindingResult bindingResult,Map<String, Object> map) {
		
		if(bindingResult.hasErrors()){
			map.put("error", true);
			return map.toString();	
		}
		
		map.put("error", false);
		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		insertedTweet.setUser(currentUser);
		twitterService.addTweet(insertedTweet);
		
		map.put("tweetObject", insertedTweet);
		
		return map.toString();
	}
	
}
