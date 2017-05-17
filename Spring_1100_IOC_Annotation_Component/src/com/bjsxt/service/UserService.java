package com.bjsxt.service;

import javax.annotation.Resource;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;

public class UserService {
	private UserDAO userDAO;
	public void init(){
		System.out.println("init");
	}
	public UserService(){
		System.out.println("UserService Created");
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void add(User u){
		userDAO.save(u);
	}
	public void destroy(){
		System.out.println("destroy");
	}
}
