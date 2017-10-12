package com.sample.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.entities.Users;

public class UserDaoImpl implements UserDao {

	private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

	@Override
	public Users getUser(String username) {
		// Try with Resources
		try (Session session = HibernateUtil.getSession()) {
			Query<Users> query = session.createNamedQuery("getUsersByFirstName", Users.class);
			query.setParameter("firstname", username);
			List<Users> userList = query.getResultList();
			return userList.get(0);
		}
	}

	@Override
	public Users createUser(Users userEntity) {
		try (Session session = HibernateUtil.getSession()) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.saveOrUpdate(userEntity);
				tx.commit();
			} catch (HibernateException hbmEx) {
				LOG.error("Hibernate Error", hbmEx);
				if (tx.isActive()) {
					tx.rollback();
				}
			}
		}
		return userEntity;
	}

	@Override
	public List<Users> getAllUsers() {
		try (Session session = HibernateUtil.getSession()) {
			Query<Users> query = session.createQuery("from Users", Users.class);
			List<Users> userList = query.getResultList();
			return userList;
		}
	}

	@Override
	public Users deleteUser(String id) {
		Users userEntity = null;
		try (Session session = HibernateUtil.getSession()) {
			userEntity = session.get(Users.class, id);
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(userEntity);
				tx.commit();
			} catch (HibernateException hbmEx) {
				LOG.error("Hibernate Error", hbmEx);
				if (tx.isActive()) {
					tx.rollback();
				}
			}
		}
		return userEntity;
	}

	@Override
	public Users updateUser(Users userEntity) {
		try (Session session = HibernateUtil.getSession()) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.saveOrUpdate(userEntity);
				tx.commit();
			} catch (HibernateException hbmEx) {
				LOG.error("Hibernate Error", hbmEx);
				if (tx.isActive()) {
					tx.rollback();
				}
			}
		}
		return userEntity;
	}

}
