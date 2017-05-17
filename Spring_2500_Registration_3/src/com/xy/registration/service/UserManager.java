package com.xy.registration.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateSessionFactory;
import com.xy.registration.model.User;

public class UserManager {
	public boolean exists(User u) throws Exception{
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query q = ss.createQuery("from User c where c.username=:username");
		
		q.setString("username", u.getUsername());
		boolean nl=q.list().isEmpty();
		ss.getTransaction().commit();
		if(nl)	{
			return false;}
		else {
			return true;}
	}
	public void add(User u) throws Exception{

		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(u);
		ss.getTransaction().commit();
	}
	public static void main(String[] args) throws Exception {
		UserManager um=new UserManager();
		User u=new User();
		u.setPassword("this is password");
		u.setUsername("this is name");
		um.exists(u);
		um.add(u);
	}
}
