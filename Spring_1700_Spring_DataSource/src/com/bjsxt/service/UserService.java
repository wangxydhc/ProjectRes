package com.bjsxt.service;

import javax.annotation.Resource;






import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;
 

public class UserService {
	private UserDAO userDAO=new UserDAOImpl();
	private int id=0;
	public UserService(){
		System.out.println("UserService "+this.id+" Created");
		id++;
		System.out.println("刚开始建立的id:"+((UserDAOImpl)userDAO).getIdd());
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="test")
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("重新赋予后的id:"+((UserDAOImpl)userDAO).getIdd());
		this.userDAO = userDAO;
		
	}
	public void add(User u){
		System.out.println("开始执行UserService的add()");
		userDAO.save(u);		
		System.out.println("结束执行UserService的add()");
	}
	
}
