package com.bjsxt.dao.impl;

import com.bjsxt.model.User;
import com.bjsxt.dao.*;

public class UserDAOImpl implements UserDAO{
	@Override
	public void save(User u){
		System.out.println("a user saved");
	}
}
