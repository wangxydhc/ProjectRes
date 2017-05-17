package com.bjsxt.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogInterceptor2 {
//	@Pointcut("execution(public * com.bjsxt.dao.impl..*.*(..))")
	public void myMethod(){};
	
//	@Before("myMethod()")
	public void before(){
		System.out.println("AAA before start!!");
	}
//	@AfterReturning("myMethod()")
	public void afterReturning(){
		System.out.println("BBB after returning!!");
	}
//	@AfterThrowing("myMethod()")
	public void afterThrowing(){
		System.out.println("CCC after throwing!!");
	}
//	@Around("myMethod()")
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("DDD method around start");
		pjp.proceed();
		System.out.println("DDDDmethod around end");
	}
}
