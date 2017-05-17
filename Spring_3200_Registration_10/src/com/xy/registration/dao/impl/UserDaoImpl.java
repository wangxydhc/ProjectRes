package com.xy.registration.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.xy.registration.dao.UserDao;
import com.xy.registration.model.User;

@Component("userDao")
public  class UserDaoImpl implements UserDao {

	HibernateTemplate hibernateTemplate;

	@Override
	public void save(User u) {
		hibernateTemplate.save(u);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate=hibernateTemplate;
	}
	@Override
	public List<User> getUsers() {
		return (List<User>) this.hibernateTemplate.find("from User");
	}
	@Override
	public boolean checkUserExistsWithName(String username) {
		List<User> users =  (List<User>) hibernateTemplate.find("from User u where u.username = '" + username + "'");
		System.out.println("what");
		for(User u:users)
			System.out.println(u.getUsername());
		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public User getUser(int id) {
		return (User)hibernateTemplate.load(User.class, id);		
	}

}
