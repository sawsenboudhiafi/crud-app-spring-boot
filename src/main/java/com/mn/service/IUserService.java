package com.mn.service;

import java.util.List;

import com.mn.entities.User;

public interface IUserService {


	User findById(long id);

    List<User> findAllUsers();

    User saveUser(User user);

	void deleteUser(User user);


}
