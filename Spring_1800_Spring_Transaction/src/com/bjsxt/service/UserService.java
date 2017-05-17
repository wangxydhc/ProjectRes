package com.bjsxt.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.LogDAO;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.LogDAOImpl;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.Log;
import com.bjsxt.model.User;
 

public class UserService {
	private UserDAO userDAO=new UserDAOImpl();
	private LogDAO logDAO=new LogDAOImpl();
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
	@Transactional
	public void add(User u){
		System.out.println("��ʼִ��UserService��add()");
		userDAO.save(u);		
		Log log=new Log();
		log.setMsg("log message");
		logDAO.save(log);
		System.out.println("����ִ��UserService��add()");
	}
	public LogDAO getLogDAO() {
		return logDAO;
	}
	@Resource(name="test2")
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}
	
}
