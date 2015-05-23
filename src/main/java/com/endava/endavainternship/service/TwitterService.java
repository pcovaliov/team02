package com.endava.endavainternship.service;

import java.util.Collection;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;


public interface TwitterService {

	public Collection<Tweet> getTweetsForUser(User user);
	public Tweet addTweet(Tweet tweet);
	public void deleteTweetByID(int tweetID);
}
