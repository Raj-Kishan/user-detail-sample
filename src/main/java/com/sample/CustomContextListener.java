package com.sample;

import java.lang.reflect.Method;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.daos.HibernateUtil;

@WebListener
public class CustomContextListener implements ServletContextListener {

	private static final Logger LOG = LoggerFactory.getLogger(CustomContextListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		try (SessionFactory factory = HibernateUtil.getSessionFactory()) {
			factory.close();
		}
		try {
			Enumeration<Driver> drivers = DriverManager.getDrivers();
			while (drivers.hasMoreElements()) {
				Driver driver = drivers.nextElement();
				LOG.info("Closing Driver Class: " + driver.getClass());
				DriverManager.deregisterDriver(driver);
				LOG.info("Driver Class Closed");
			}
		} catch (SQLException ex) {
			LOG.info("Error while de-registering JDBC Driver", ex);
		}

		// MY-SQL Specific
		try {
			Class<?> cls = Class.forName("com.mysql.jdbc.AbandonedConnectionCleanupThread");
			Method mth = (cls == null ? null : cls.getMethod("shutdown"));
			if (mth != null) {
				LOG.info("Shutting down MySQL connection cleanup thread");
				mth.invoke(null);
				LOG.info("MySQL connection cleanup thread shutdown successful");
			}
		} catch (Throwable thr) {
			LOG.error("Failed to shutdown SQL connection cleanup thread: " + thr.getMessage(), thr);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		LOG.info("Context Initialized");
	}

}
