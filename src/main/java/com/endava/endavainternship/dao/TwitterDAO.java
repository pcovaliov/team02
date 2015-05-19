package com.endava.endavainternship.dao;

import java.util.Collection;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;

public interface TwitterDAO {

	public Collection<Tweet> getTweetsForUser(User user);
	public Tweet insertTweet(Tweet tweet);
	
}