package by.it.academy.my.dal.db.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		
		Configuration config = new Configuration().configure();
		
		ServiceRegistry serviceRegistry =
				new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession() {
		
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
}
