package com.bjsxt.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.model.User;

public class UserServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext factory=new ClassPathXmlApplicationContext("Copy of beans.xml");
		UserService service=(UserService)factory.getBean("userService");
		service.add(new User());
		factory.destroy();
	}

}
