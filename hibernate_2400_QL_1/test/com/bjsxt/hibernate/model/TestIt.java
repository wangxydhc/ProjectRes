package com.bjsxt.hibernate.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIt {
	private static SessionFactory sf = null;

	@BeforeClass
	public static void beforeclass() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(
				true, true);
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testSave() {
		Session s = sf.openSession();
		s.beginTransaction();
		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setName("c" + i);
			s.save(c);
		}
		Category c = new Category();
		c.setId(1);
		for (int i = 0; i < 10; i++) {

			Topic t = new Topic();
			t.setCategory(c);
			t.setName("t" + i);
			t.setDate(new Date());
			s.save(t);
		}
		Topic t = new Topic();
		t.setId(1);
		for (int i = 0; i < 10; i++) {
			Msg m = new Msg();
			m.setCount("m" + i);
			m.setTopic(t);
			s.save(m);
		}

		s.getTransaction().commit();

	}

	@Test
	public void testHql() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Category");
		List<Category> categories = (List<Category>) q.list();
		for (Category d : categories) {
			System.out.println(d.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql2() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Category c where c.name>'c5'");
		List<Category> categories = (List<Category>) q.list();
		for (Category d : categories) {
			System.out.println(d.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql3() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Category c order by c.name desc");
		List<Category> categories = (List<Category>) q.list();
		for (Category d : categories) {
			System.out.println(d.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql4() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s
				.createQuery("select distinct c from Category c order by c.name desc");
		List<Category> categories = (List<Category>) q.list();
		for (Category d : categories) {
			System.out.println(d.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql5() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s
				.createQuery("from Category c where c.id>:min and c.id < :max");
		q.setParameter("min", 2);
		q.setParameter("max", 8);
		List<Category> categories = (List<Category>) q.list();
		for (Category d : categories) {
			System.out.println(d.getId() + " " + d.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql6() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s
				.createQuery("select c.id,  c.name from Category c order by c.name desc");
		List<Object[]> categories = (List<Object[]>) q.list();
		for (Object[] o : categories) {
			System.out.println(o[0] + "-" + o[1]);
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql7() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Topic t where t.category.id=1");
		List<Topic> categories = (List<Topic>) q.list();
		for (Topic o : categories) {
			System.out.println(o.getName());
		}
		s.getTransaction().commit();
	}

	@Test
	public void testHql8() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		Query q = s.createQuery("from Msg m where m.topic.category.id = 1");
		for (Object o : q.list()) {
			Msg m = (Msg) o;
			System.out.println(m.getCount());
		}
		s.getTransaction().commit();
	}
	@Test
	public void testHql9() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
		 Query q =s.createQuery("select new com.bjsxt.hibernate.model.MsgInfo(m.id, m.count, m.topic.name, m.topic.category.name) from Msg m");
	        for(Object o : q.list()) {
	            MsgInfo m = (MsgInfo)o;
	            System.out.println(m.getId()+" "+m.getTopicName()+" "+m.getCont());
	        }
		s.getTransaction().commit();
	}
	@Test
	public void testHql10() {
		testSave();
		Session s = sf.openSession();
		s.beginTransaction();
	      Query q =s.createQuery("select t.name, c.name from Topic t join t.category c "); //join Category c
	        for(Object o : q.list()) {
	            Object[] m = (Object[])o;
	            System.out.println(m[0] + "-" + m[1]);
	        }
		s.getTransaction().commit();
	}
	public static void main(String[] args) {
		beforeclass();
	}

	@AfterClass
	public static void afterclass() {
		sf.close();
	}
}
