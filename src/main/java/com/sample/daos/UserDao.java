package com.sample.daos;

import java.util.List;

import com.sample.entities.Users;

public interface UserDao {

	Users getUser(String username);

	Users createUser(Users userEntity);

	List<Users> getAllUsers();

	Users deleteUser(String id);

	Users updateUser(Users userEntity);
}
