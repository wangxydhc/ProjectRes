package com.bjsxt.hibernate.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	private static SessionFactory sf=null;
	@BeforeClass
	public static void beforeclass(){
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	@Test
	public void testTeacherSave() {
		Teacher t=new Teacher();
		t.setName("teacher");
		t.setTitle("high");
		t.setWifename("dsdafsa");
		t.setBirthDate(new Date());
		
		Configuration cfg= new AnnotationConfiguration();
//		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session ss=sf.openSession();
		ss.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	@AfterClass
	public static void afterclass(){
		sf.close();
	}
	

}
