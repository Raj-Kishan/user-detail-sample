package com.sample.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final HibernateUtil instance = new HibernateUtil();
	private static SessionFactory sessionFactory;

	private HibernateUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		sessionFactory = configuration.buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		return instance;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
