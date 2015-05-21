package com.endava.endavainternship.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.endavainternship.dao.TwitterDAO;
import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;


@Service
public class TwitterServiceImpl implements TwitterService {
	
	@Autowired
	private TwitterDAO twitterDAO;

	@Override
	public Collection<Tweet> getTweetsForUser(User user,int limit , int offset) {
		
		if(user == null)
			return null;
		return twitterDAO.getTweetsForUser(user,limit,offset );
		
	}

	@Override
	public Tweet addTweet(Tweet tweet) {
		
		return twitterDAO.insertTweet(tweet);
		
	}
	

	
}
