package com.bjsxt.dao.impl;





import org.springframework.stereotype.Component;

import com.bjsxt.model.User;
import com.bjsxt.dao.*;

@Component("test")
public class UserDAOImpl implements UserDAO{
	@Override
	public void save(User u){
		System.out.println("开始执行UserDAOImpl的save()");	
		System.out.println("a user saved");
		System.out.println("结束执行UserDAOImpl的save()");
//		throw new RuntimeException("哈哈哈");
	}
}
