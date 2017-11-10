package br.fiap.roteiro3.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.SessionStatistics;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;


	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}