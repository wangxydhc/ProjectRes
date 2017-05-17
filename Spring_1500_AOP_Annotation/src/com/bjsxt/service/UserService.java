package com.bjsxt.service;

import javax.annotation.Resource;



import org.springframework.beans.factory.annotation.Autowired;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;

public class UserService {
	private UserDAO userDAO=new UserDAOImpl();
	public UserService(){
		System.out.println("UserService"+this.userDAO.toString()+"Created");
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="test")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void add(User u){
		System.out.println("开始执行UserService的add()");
		userDAO.save(u);		
		System.out.println("结束执行UserService的add()");
	}
}
