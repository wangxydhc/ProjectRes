package com.bjsxt.dao.impl;





import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.model.User;

@Component("test")
public class UserDAOImpl implements UserDAO{
	private static int id=0;
	private int idd;
	private SessionFactory sessionFactory;

	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		UserDAOImpl.id = id;
	}
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	@Override
	public void save(User u) {
		System.out.println("^^:"+u.getId());
		Session s=sessionFactory.getCurrentSession();
		s.save(u);
		System.out.println("a user saved");
	}

	public SessionFactory getSessionFactory() {
		System.out.println("getSessionFactory");
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("setSessionFactory");
	}
}
