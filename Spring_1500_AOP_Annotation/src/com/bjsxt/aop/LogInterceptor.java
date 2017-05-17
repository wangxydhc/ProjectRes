package com.bjsxt.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.bjsxt.dao.UserDAO;
import com.bjsxt.dao.impl.UserDAOImpl;
import com.bjsxt.model.User;



public class LogInterceptor implements InvocationHandler{
	private Object target;
	public void beforeMethod(Method m){
		System.out.println(m.getName()+"(method name) start");
	}
	public void afterMethod(Method m){
		System.out.println(m.getName()+"(method name) finish");
	}
	public Object getTarget(){
		return target;
	}
	public void setTarget(Object target){
		this.target=target;
	}
	public Object bind(Object target){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
		
	}
	@Override
	public Object invoke(Object proxy,Method method,Object[]args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object result=null;
		beforeMethod(method);
		result=method.invoke(target, args);		
		afterMethod(method);
		return result;
	}
	public static void main(String[] args) {
		LogInterceptor proxy=new LogInterceptor();
		UserDAO userDAO=new UserDAOImpl();
		proxy.setTarget(userDAO);
		UserDAO o=(UserDAO)proxy.bind(userDAO);
		o.save(new User());
	}



}
