package models;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		 StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		 SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		 
		 return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			sessionFactory = buildSessionFactory();
		return sessionFactory;
	}
}
