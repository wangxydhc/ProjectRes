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
	public void testSave(){
		Org o=new Org();
		o.setName("总公司");
		Org o1=new Org();
		o1.setName("分公司1");
		Org o2=new Org();
		o2.setName("分公司2");
		Org o11=new Org();
		o11.setName("分公司1下部门1");
		Org o12=new Org();
		o12.setName("分公司1下部门2");
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o11.setParent(o1);
		o12.setParent(o1);
		o1.setParent(o);
		o2.setParent(o);
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(o);
		s.getTransaction().commit();
		s.save(o);
	}
	@Test
	public void testLoad(){
		testSave();			
		Session s=sf.openSession();
		s.beginTransaction();
		Org o=(Org)s.load(Org.class, 1);
		print(o,0);
		
		s.getTransaction().commit();
		s.save(o);
	}
	private void print(Org o,int level){
		String preStr="";
		for (int i=0;i<level;i++){
			preStr+="-----";
		}
		System.out.println(preStr+o.getName());
		for (Org child: o.getChildren())
			print(child,level+1);
	}
//	@Test
//	public void testGetUser(){
//		
//		testSaveGroup();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		s.getTransaction().commit();
//		User u=(User)s.get(User.class, 1);
//	}
//	@Test
//	public void testGetGroup(){		
//		testSaveGroup();
//		Session s=sf.openSession();
//		s.beginTransaction();
//		Group g=(Group)s.get(Group.class, 1);
//		s.getTransaction().commit();
////		for (User ue:g.getUsers())
////			System.out.println("idΪ1��User:"+ue.getName());
//
//	}
//	@Test
//	public void testDeleteGroup(){
//		testSaveGroup();
//		Session s=sf.openSession();
//		s.beginTransaction();
////		User u=(User)s.load(User.class, 1);
////		u.setGroup(null);
////		s.delete(u);
//		Group g=(Group)s.load(Group.class,1);
//		s.delete(g);
////		s.createQuery("delete from User u where u.id=1").executeUpdate();
//		s.getTransaction().commit();
//
//	}
	public static void main(String[] args) {
		beforeclass();
	}
	@AfterClass
	public static void afterclass(){
		sf.close();
	}
}
