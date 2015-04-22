package com.endava.twitter.dao;
import java.util.List;

import com.endava.twitter.entity.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}

	public void removeUser(User user) {
			if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}
	
	public void updateUser(User user) {
		    if (null != user) {
			sessionFactory.getCurrentSession().update(user);
		}
    
	}
	
	public void findById(User user){
		if (null != user) {
			//to write code tomorrow
		//	sessionFactory.getCurrentSession().//load(user);
		}
	}
	
}