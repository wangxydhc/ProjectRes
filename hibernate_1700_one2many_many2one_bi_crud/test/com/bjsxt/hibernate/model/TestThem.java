package com.bjsxt.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestThem {
	private static SessionFactory sf=null;
	@BeforeClass
	public static void beforeclass(){
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
//	@Test
//	public void testTeacherSave() {
//		Teacher t=new Teacher();
//		t.setName("teacher");
//		t.setTitle("high");
//		t.setWifename("dsdafsa");
//		t.setBirthDate(new Date());
//		
//		Configuration cfg= new AnnotationConfiguration();
//		SessionFactory sf=cfg.configure().buildSessionFactory();
//		Session session=sf.openSession();
//		session.beginTransaction();
//		session.save(t);
//		session.getTransaction().commit();
//		session.close();
//		sf.close();
//	}
	@Test
	public void testSchemaExport(){
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}
	@Test
	public void testSaveUser(){
		User u=new User();
		u.setName("u1");
		Group g=new Group();
		u.setGroup(g);
		g.setName("g1");
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
	}
	@Test
	public void testSaveGroup(){
		User u1=new User();
		u1.setName("u1");
		User u2=new User();
		u2.setName("u2");
		User u3=new User();
		u3.setName("u3");
		Group g=new Group();
		g.setName("g1");
		g.getUsers().add(u1);
		g.getUsers().add(u2);
		u1.setGroup(g);
		u2.setGroup(g);
				Session s=sf.openSession();
		s.beginTransaction();
		s.save(g);
		s.getTransaction().commit();
	}
	public void testSaveUser2(){
		User u1=new User();
		u1.setName("u1");
		
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(u1);
		s.getTransaction().commit();
	}
	public void testGetUser(){
	
		testSaveGroup();
		Session s=sf.openSession();
		s.beginTransaction();
		 User u=(User)s.get(User.class, 1);
		s.getTransaction().commit();
	}
	@AfterClass
	public static void afterclass(){
		sf.close();
	}
	

}
