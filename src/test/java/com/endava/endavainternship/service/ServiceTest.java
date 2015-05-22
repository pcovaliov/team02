package com.endava.endavainternship.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.aspectj.lang.annotation.Before;
import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.configuration.Registry;
import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.UserService;
import com.endava.endavainternship.service.TwitterService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {

	final static ApplicationContext appContext = Registry.getContext("test-context.xml");
	// services
	static UserService userService;
	static TwitterService twitterService;
		
	// variables
	static User testUser;
	static Tweet testTweet;
	
	@BeforeClass
	static public void contextIntialization() {
		userService = (UserService) appContext.getBean("userService");
		twitterService = (TwitterService) appContext.getBean("twitterService");
		
		// generating a dummy user to work on
		testUser = new User();

		// used to generate user data, avoids db conflicts
		Random r = new Random();
		int randomNumber = r.nextInt(99999 + 1);

		testUser.setEmail("testTweet" + randomNumber + "@mail.com");
		testUser.setFirstname("TestTweet");
		testUser.setLastname("InsertNewUser");

		userService.addUser(testUser);
		// end user generation
		
		//generating a tweet and linking it with the user
				testTweet = new Tweet();
				testTweet.setUser(testUser);
		}

	@AfterClass
	static public void contextCleaning() {
		assertNotNull(testUser);
		userService.removeUserByID(testUser.getId());
	}

	
	@Test
	@Transactional
	public void shouldAddUser() {

		User user = new User();
		Random r = new Random();
		int randomNumber = r.nextInt(99999 + 1);

		user.setEmail("test" + randomNumber + "@mail.com");
		user.setFirstname("Test");
		user.setLastname("InsertnewUser");

		userService.addUser(user);
		assertTrue(user != null);
	}

	@Test
	public void shouldFindUserById() {

		User user = userService.findUserById(testUser.getId());

		assertTrue(user != null);

	}

	@Test
	public void shouldFindUserByEmail() {

		User user = userService.findUserByEmail(testUser.getEmail());

		assertNotNull(user);

	}

	@Test
	@Transactional
	public void shouldUpdateUser() {

		User user = userService.findUserById(testUser.getId());
		System.out.println(user);
		String newLastName = user.getLastname() + "EDIT";
		String newFirstName = user.getFirstname() + "EDIT";

		user.setLastname(newLastName);
		user.setFirstname(newFirstName);
		System.out.println(userService.updateUser(user));

		// retrieving new name from database
		user = userService.findUserById(testUser.getId());
		System.out.println(user);
		assertEquals(user.getLastname(), newLastName);
	}
	

	@Test
	public void shouldAddTweet() {
		testTweet.setId(null); //to make sure it's sent as null to insert
		testTweet.setTweet("TEST Tweet ");
		twitterService.addTweet(testTweet);
		assertNotNull(testTweet.getId());
	}
	

	@Test
	public void shouldGetTweetsForUser() {
		//creating the tweets for the user
		int insertedTweets = 0;
		
		for (int i = 0; i < 10; i++) {
			testTweet.setId(null); //to make sure it's sent as null to insert
			testTweet.setTweet("TEST Tweet " + i);
			twitterService.addTweet(testTweet);
			assertNotNull(testTweet.getId()); //just to check it not fails ...
			// todo: comment later
			insertedTweets++;
		}
		
		
		List<Tweet> listOfTweets = (List<Tweet>) twitterService.getTweetsForUser(testUser);
		assertTrue(listOfTweets.size() == insertedTweets);
	}
	
	@Test
	@Transactional
	public void shouldXDeleteUser() {

		User user = userService.findUserById(testUser.getId());

		userService.removeUserByID(testUser.getId());
		
		assertNotNull(user);

	}
	
}

