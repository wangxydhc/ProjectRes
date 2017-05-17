package com.bjsxt.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIt {
	private static SessionFactory sf=null;
	@BeforeClass
	public static void beforeclass(){
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
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
	@Test
	public void testGetUser(){
		
		testSaveGroup();
		Session s=sf.openSession();
		s.beginTransaction();
		s.getTransaction().commit();
		User u=(User)s.get(User.class, 1);
	}
	@Test
	public void testGetGroup(){		
		testSaveGroup();
		Session s=sf.openSession();
		s.beginTransaction();
		Group g=(Group)s.get(Group.class, 1);
		s.getTransaction().commit();
//		for (User ue:g.getUsers())
//			System.out.println("idÎª1µÄUser:"+ue.getName());

	}
	@Test
	public void testDeleteGroup(){
		testSaveGroup();
		Session s=sf.openSession();
		s.beginTransaction();
//		User u=(User)s.load(User.class, 1);
//		u.setGroup(null);
//		s.delete(u);
		Group g=(Group)s.load(Group.class,1);
		s.delete(g);
//		s.createQuery("delete from User u where u.id=1").executeUpdate();
		s.getTransaction().commit();

	}
	@AfterClass
	public static void afterclass(){
		sf.close();
	}
}
