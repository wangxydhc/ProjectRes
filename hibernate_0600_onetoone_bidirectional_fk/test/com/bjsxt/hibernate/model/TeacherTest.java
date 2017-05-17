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

public class TeacherTest {
//	private static SessionFactory sf=null;
	//@BeforeClass
//	public static void beforeclass(){
//		sf=new AnnotationConfiguration().configure().buildSessionFactory();
//	}
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
	//@AfterClass
//	public static void afterclass(){
//		sf.close();
//	}
	

}
