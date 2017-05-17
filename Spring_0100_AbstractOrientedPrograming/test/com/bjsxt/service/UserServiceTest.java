package com.bjsxt.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.bjsxt.model.User;
import com.bjsxt.spring.BeanFactory;
import com.bjsxt.spring.ClassPathXmlApplicationContext;

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
		BeanFactory factory=new ClassPathXmlApplicationContext();
		UserService service=(UserService)factory.getBean("userService");
		User u=new User();
		service.add(u);
	}

}
