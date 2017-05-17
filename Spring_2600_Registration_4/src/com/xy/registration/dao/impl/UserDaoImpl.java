package com.xy.registration.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.HibernateSessionFactory;
import com.xy.registration.dao.UserDao;
import com.xy.registration.model.User;

public class UserDaoImpl implements UserDao {
	@Override
	public void save(User u){
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		ss.save(u);
		ss.getTransaction().commit();
	}
	@Override
	public boolean checkUserExistsWithName(String username){
		SessionFactory sf = HibernateSessionFactory.getSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		Query q = ss.createQuery("from User c where c.username=:username");
		
		q.setString("username", username);
		boolean nl=q.list().isEmpty();
		ss.getTransaction().commit();
		if(nl)	{
			return false;}
		else {
			return true;}
	};
}
