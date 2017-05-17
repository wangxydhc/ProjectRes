import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.bjsxt.hibernate.model.Student;


public class StudentTest {
	public static void main(String[] args) {
		Student s=new Student();
		s.setId(16);
		s.setName("sr");
		s.setAge(34);
		Configuration cfg= new Configuration();
//		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
