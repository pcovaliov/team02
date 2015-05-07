package com.endava.endavainternship.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.dao.UserDAO;



@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
 
	//get user from the database, via Hibernate
	@Autowired
	private UserDAO userDao;
 
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
		
		System.out.println(username);
		com.endava.endavainternship.entity.User user = userDao.findUserByEmail(username);
		System.out.println(user.getRole());
		return user;//buildUserForAuthentication(user);
	}
 
	// Converts our "User" to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.endava.endavainternship.entity.User user) {
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		return new User(user.getEmail(), "", true, true, true, true, authorities);
	}
}
