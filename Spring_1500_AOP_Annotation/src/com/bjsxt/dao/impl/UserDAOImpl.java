package com.bjsxt.dao.impl;





import org.springframework.stereotype.Component;

import com.bjsxt.model.User;
import com.bjsxt.dao.*;

@Component("test")
public class UserDAOImpl implements UserDAO{
	@Override
	public void save(User u){
		System.out.println("��ʼִ��UserDAOImpl��save()");	
		System.out.println("a user saved");
		System.out.println("����ִ��UserDAOImpl��save()");
//		throw new RuntimeException("������");
	}
}
