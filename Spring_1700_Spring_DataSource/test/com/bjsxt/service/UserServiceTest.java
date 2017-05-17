package com.bjsxt.service;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;

//Ä£Äâspring
public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext sessionfactory=new ClassPathXmlApplicationContext("beans.xml");

		Object been=sessionfactory.getBean("userService");
		System.out.println("##############################");		
//		DataSource sour=(DataSource)sessionfactory.getBean("myDataSource");
//		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
//		factory.setDataSource(sour);
//		System.out.println("------------------------------------");
//		UserDAOImpl imp=new UserDAOImpl();
//		System.out.println("------------------------------------");
//		imp.setSessionFactory(factory.getObject());
//		System.out.println("------------------------------------");
//		UserService service=new UserService();
//		System.out.println("------------------------------------");
//		service.setUserDAO(imp);
//		System.out.println("*****************************");
		
		
  		UserService service=(UserService)been;
  		System.out.println("------------------------------------");
		User u=new User();
		u.setName("je");
		service.add(u);
	}

	@Test
	public void testProxy(){
		UserDAO userDAO=new UserDAOImpl();
		LogInterceptor proxy=new LogInterceptor();
		proxy.setTarget(userDAO);
		UserDAO userDAOProxy=(UserDAO)proxy.bind(userDAO);
		System.out.println(userDAOProxy.getClass());
		userDAOProxy.save(new User());
	}
}
