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
		System.out.println("UserDaoImpl.save"+u.getUsername());
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
		System.out.println("UserDaoImp.check1"+username);
		List<User> users =  (List<User>) hibernateTemplate.find("from User u where u.username = '" + username + "'");
		for(User u:users)
			System.out.println("UserDaoImp.check2"+u.getUsername());
		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public User getUser(int id) {
		User u=(User)hibernateTemplate.load(User.class, id);	
		System.out.println("UserDaoImpl.getUser:"+u.getUsername());
		return u;
	}

}
