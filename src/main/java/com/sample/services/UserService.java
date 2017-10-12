package com.sample.services;

import com.sample.schemas.User;

public interface UserService {

	User getUser(String username);

	User createUser(User user);

	com.sample.schemas.Users getAllUsers();

	User deleteUser(String id);

	User updateUser(User user);
}
