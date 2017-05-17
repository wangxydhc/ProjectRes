package com.xy.registratiion.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xy.registration.action.UserAction;
import com.xy.registration.dto.UserInfo;

public class UserManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testExists() {
//		UserManager um=new UserManagerImpl();
//		User u=new User();
//		u.setUsername("wang");
//		u.setPassword("123");
//		boolean exists=um.equals(u);
//		Assert.assertEquals(exists, false); 
//	}
//	@Test
//	public void testAdd () throws Exception{
//		UserManager um=new UserManagerImpl();
//		User u=new User();
//		u.setPassword("ab");
//		u.setUsername("acb");
//		boolean exists=um.exists(u);
//		if(!exists){
//			um.add(u);
//			Assert.assertEquals(true,um.exists(u));
//		}
//		else{
//			Assert.fail("not added");
//		}
//		
//	}
	@Test
	public void testList() throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua=(UserAction)ctx.getBean("user");
		ua.list();		
		Assert.assertTrue(ua.getUsers().size()>0);
		
	}
	@Test
	public void testExecute() throws Exception
	{
			UserAction ua=new UserAction();
			UserInfo ui=new UserInfo();
			ui.setPassword("ps");
			ui.setPassword2("pw2");
			ui.setUsername("un");
			ua.setUserInfo(ui);
			String ret=ua.execute();
			Assert.assertEquals("success",ret);			
		
	}

}
