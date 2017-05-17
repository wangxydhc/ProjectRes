package com.bjsxt.dao.impl;





import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.LogDAO;
import com.bjsxt.model.Log;

@Component("test2")
public class LogDAOImpl implements LogDAO{

	private SessionFactory sessionFactory;


	@Override
	public void save(Log log) {
		Session s=sessionFactory.getCurrentSession();
		s.save(log);
//		throw new RuntimeException("error");
//		System.out.println("½áÊøÖ´ÐÐUserDAOImplµÄsave()");
//		throw new RuntimeException("¹þ¹þ¹þ");
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
