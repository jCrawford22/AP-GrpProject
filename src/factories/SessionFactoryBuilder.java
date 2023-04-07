package factories;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;





public class SessionFactoryBuilder {
private static SessionFactory session;
	
	public static SessionFactory getSessionFactory() {
		if(session==null) {
			session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}
		return session;
	}
	
	public static void closeSessionFactory() {
		if(session!=null) {
			session.close();
		}
	}
	
}
