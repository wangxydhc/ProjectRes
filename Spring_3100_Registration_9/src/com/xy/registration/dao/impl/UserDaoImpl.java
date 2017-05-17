package com.xy.registration.dao.impl;

import java.util.List;







import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.xy.registration.dao.UserDao;
import com.xy.registration.model.User;

public  class UserDaoImpl implements UserDao {
	
	HibernateTemplate ht=new HibernateTemplate(new AnnotationConfiguration().configure().buildSessionFactory());
	
	@Override
	public void save(User u) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();

		Session ss=sf.openSession();		  
		ss.beginTransaction();
		ss.save(u);
		ss.getTransaction().commit();
	}

	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	
	}
	@Override
	public List<User> getUsers() {
		return (List<User>) this.ht.find("from User");
	}


	@Override
	public boolean checkUserExistsWithName(String username) {
		List<User> users =  (List<User>) ht.find("from User u where u.username = '" + username + "'");
		System.out.println("what");
		for(User u:users)
			System.out.println(u.getUsername());
		if (users != null && users.size() > 0) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		UserDaoImpl userDI=new UserDaoImpl();
		userDI.checkUserExistsWithName("123");
		for(User u:userDI.getUsers())
			System.out.println(u.getUsername());
		
	}

}
