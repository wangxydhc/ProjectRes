package com.bjsxt.dao.impl;



import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

public class UserDAOImpl3 implements UserDAO{
	private UserDAO userDAO=new UserDAOImpl();
	public void save(User user){
		new LogInterceptor().beforeMethod(null);
		System.out.println("save start...");
		userDAO.save(user);
	}

}
