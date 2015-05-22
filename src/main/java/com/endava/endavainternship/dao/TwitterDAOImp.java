package com.endava.endavainternship.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endava.endavainternship.entity.Tweet;
import com.endava.endavainternship.entity.User;


@Repository
@Transactional
public class TwitterDAOImp  implements TwitterDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Collection<Tweet> getTweetsForUser(User user) {
		
		Query q = sessionFactory.getCurrentSession().createQuery("from Tweet t where t.user = :user_id order by t.date DESC");
		q.setInteger("user_id", user.getId());
		
		return q.list();
		
		
	}

	@Override
	public Tweet insertTweet(Tweet tweet) {
		sessionFactory.getCurrentSession().save(tweet);
		return tweet;
	}

}
