package com.endava.endavainternship;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.TwitterService;
import com.endava.endavainternship.service.UserService;

public class TweetController {
	private static final Logger logger = LoggerFactory
			.getLogger(TweetController.class);
	
	@Autowired
	private TwitterService twiterService;
	@Autowired
	private UserService userService;

	
	
	

}
