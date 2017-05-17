package com.bjsxt.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;

//ģ��spring
public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("beans.xml");
  		UserService service=(UserService)factory.getBean("userService");
  		System.out.println(service.getUserDAO());
		User u=new User();
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
