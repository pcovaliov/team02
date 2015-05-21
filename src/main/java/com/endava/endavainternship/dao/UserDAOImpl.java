package com.endava.endavainternship.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.endava.endavainternship.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		logger.info("User was saved " + user);
		
		

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> listUser() {

		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	@Override
	public void removeUser(User user) {
		
			if (null != user) {
		
			sessionFactory.getCurrentSession().delete(user);

			
		} 

	}

	@Override
	public User findUserById(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				id);
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		List result = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.email=?")
				.setString(0, email).list();
		System.out.println(result.size());
		if (result.size() != 0) {
			return (User) result.get(0); // returning first element
		} else {
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {

		User userFound = findUserByEmail(user.getEmail());
		System.out.println(userFound);
		if( userFound != null && userFound.getId().equals(user.getId())){
				sessionFactory.getCurrentSession().merge(user);

				return true;
			} else {
				return false;

			}
		

	}
}
