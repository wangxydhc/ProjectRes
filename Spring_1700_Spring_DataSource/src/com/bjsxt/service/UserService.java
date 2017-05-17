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
		System.out.println("�տ�ʼ������id:"+((UserDAOImpl)userDAO).getIdd());
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="test")
	public void setUserDAO(UserDAO userDAO) {
		System.out.println("���¸�����id:"+((UserDAOImpl)userDAO).getIdd());
		this.userDAO = userDAO;
		
	}
	public void add(User u){
		System.out.println("��ʼִ��UserService��add()");
		userDAO.save(u);		
		System.out.println("����ִ��UserService��add()");
	}
	
}
