package com.xy.registratiion.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.xy.registration.model.User;
import com.xy.registration.service.UserManager;

public class UserManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExists() {
		UserManager um=new UserManager();
		User u=new User();
		u.setUsername("wang");
		u.setPassword("123");
		boolean exists=um.equals(u);
		Assert.assertEquals(exists, false); 
	}

}
