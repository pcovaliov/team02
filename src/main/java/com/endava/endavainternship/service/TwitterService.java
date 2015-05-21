package com.endava.endavainternship.service;

import java.util.Collection;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;


public interface TwitterService {

	public Collection<Tweet> getTweetsForUser(User user,int limit, int offset);
	public Tweet addTweet(Tweet tweet);
}
