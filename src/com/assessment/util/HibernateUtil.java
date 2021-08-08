package com.assessment.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			StandardServiceRegistry standard = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			
			Metadata metaData = new MetadataSources(standard).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		}catch (Throwable e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
