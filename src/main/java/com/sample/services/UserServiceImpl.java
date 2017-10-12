package com.sample.services;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.sample.daos.UserDao;
import com.sample.daos.UserDaoImpl;
import com.sample.entities.Users;
import com.sample.schemas.User;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String username) {
		UserDao userDao = new UserDaoImpl();
		Users user = userDao.getUser(username);
		return mapUser(user);
	}

	@Override
	public User createUser(User user) {
		UserDao userDao = new UserDaoImpl();
		String userId = UUID.randomUUID().toString().toUpperCase(Locale.ENGLISH);
		Users userEntity = createUserEntity(user, userId);
		return mapUser(userDao.createUser(userEntity));
	}

	@Override
	public com.sample.schemas.Users getAllUsers() {
		UserDao userDao = new UserDaoImpl();
		List<Users> usersList = userDao.getAllUsers();

		com.sample.schemas.Users usersJaxb = new com.sample.schemas.Users();
		for (Users user : usersList) {
			User userJaxb = mapUser(user);
			usersJaxb.getUser().add(userJaxb);
		}
		return usersJaxb;
	}

	@Override
	public User deleteUser(String id) {
		UserDao userDao = new UserDaoImpl();
		Users usersEntity = userDao.deleteUser(id);
		return mapUser(usersEntity);
	}

	@Override
	public User updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		Users userEntity = userDao.updateUser(createUserEntity(user, user.getUserId()));
		
		return mapUser(userEntity);
	}

	private Users createUserEntity(User user, String id) {
		Users users = new Users(id);
		users.setFirstname(user.getFirstName());
		users.setLastname(user.getLastName());
		users.setAge(user.getAge());
		users.setJoineddate(user.getJoinedDate().toGregorianCalendar().getTime());

		return users;
	}

	private User mapUser(Users topUser) {
		User user = new User();
		user.setFirstName(topUser.getFirstname());
		user.setLastName(topUser.getLastname());
		user.setAge(topUser.getAge());
		user.setJoinedDate(convertDateToXmlCalendar(topUser.getJoineddate()));
		user.setUserId(topUser.getUserId());

		return user;
	}

	private XMLGregorianCalendar convertDateToXmlCalendar(Date dateToConvert) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateToConvert);
		try {
			XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
			return xmlCal;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

}
