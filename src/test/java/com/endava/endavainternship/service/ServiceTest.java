package com.endava.endavainternship.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.configuration.Registry;
import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;
import com.endava.endavainternship.service.UserService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {

	final ApplicationContext appContext = Registry.getContext("test-context.xml");
	
	static List<User> testUsers = new ArrayList<User>();
	
	
	 @Test
	 @Transactional
	 public void AInsertUser() {
	  UserService service = (UserService) appContext.getBean("userService");
	  User user1 = new User();
	
	  int min = 0;
	  int max = 100;

	  Random r = new Random();
	  int i1 = r.nextInt(max - min + 1) + min;
	  
	  user1.setEmail("test"+i1+"@mail.com");
	  user1.setFirstname("Test");
	  user1.setLastname("newUser");
	  service.addUser(user1);
	  testUsers.add(user1);
	  assertTrue(user1 != null);
	  
	 }
	 
	 
	@Test
	public void BFindUserById() {
		
		UserService service = (UserService) appContext.getBean("userService");
		User user = service.findUserById(testUsers.get(0).getId());
		assertTrue(user != null);
	}
	
	@Test
	 public void CFindUserByEmail() {

	  UserService service = (UserService) appContext.getBean("userService");
	  User user = service.findUserByEmail(testUsers.get(0).getEmail());
	  assertTrue(user != null);
	 }
	
		
	 @Test
	 @Transactional
	 public void DUpdateUser() {

	  UserService service = (UserService) appContext.getBean("userService");
	  User user = service.findUserById(testUsers.get(0).getId());

	  String newLastName = user.getLastname() + "EDIT";
	  String newFirstName = user.getFirstname() + "Edit";

	  user.setLastname(newLastName);
	  user.setFirstname(newFirstName);
	  service.updateUser(user);
	  assertEquals(user.getLastname(), newLastName);
	 }
	 
	 @Test
	 @Transactional
	 public void EDeleteUser(){
		 
		 UserService service = (UserService) appContext.getBean("userService");
		 User user = service.findUserById(testUsers.get(0).getId());
		 System.out.println(user.getId());
		 service.removeUser(user);
		 System.out.println(user.getId());
		 assertNotNull(user);
		 
	 }
	 
	 @Test
	 @Transactional
	 public void FInsertTweet(){
	 UserService service = (UserService) appContext.getBean("userService");
	  User user = service.findUserById(4);

	  TwitterService twitterservice = (TwitterService) appContext.getBean("twitterService");
	  Tweet tweet = new Tweet();
	  
	  tweet.setUser(user);
	  tweet.setTweet("TEST Tweet");
	  twitterservice.addTweet(tweet);
	  
	  assertTrue(tweet.getId() != null);
	 }
	 
	/* @Test
	 @Transactional
	 public void GListOfTweet(){
		 UserService service = (UserService) appContext.getBean("userService");
		 User user = service.findUserById(4);

		 TwitterService twitterservice = (TwitterService) appContext.getBean("twitterService");
		 
		 
		 
	 }	 
	*/
}

