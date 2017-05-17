package com.bjsxt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;

public class UserDAOProxy implements InvocationHandler{
	
	private Object target;
	
	public Object bind(Object target){
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		
	}
	public void delete(){
		System.out.println("userDAOProxy is deleted");
	}
	@Override
	public Object invoke(Object proxy,Method method,Object[]args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object result=null;
		System.out.println("before");
		result=method.invoke(target, args);		
		System.out.println("after");
		return result;
	}
	public static void main(String[] args) {
		UserDAOProxy proxy=new UserDAOProxy();
		UserDAO userDAO=new UserDAOImpl();
		UserDAO o=(UserDAO)proxy.bind(userDAO);
		o.save(new User());
	}
}
