package com.xy.registration.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.xy.registration.dao.UserDao;
import com.xy.registration.dao.impl.UserDaoImpl;
import com.xy.registration.model.User;
import com.xy.registration.service.UserManager;

@Component("um")
@Scope("prototype")
public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	@Override
	public boolean exists(User u) throws Exception{
		return userDao.checkUserExistsWithName(u.getUsername());
	}
	@Override
	public void add(User u){
		userDao.save(u);
	}
	public UserDao getUserDao() {
		return userDao;
	}	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getUsers() {
		return this.userDao.getUsers();		
	}

	@Override
	public User getUser(int id) {		
		return this.userDao.getUser(id);
	}

}
