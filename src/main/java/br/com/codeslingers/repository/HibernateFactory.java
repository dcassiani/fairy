package br.com.codeslingers.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
