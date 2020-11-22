package com.mn.service;

import java.util.List;

import com.mn.entities.UserEntity;

public interface IUserService {


	UserEntity findById(long id);

    List<UserEntity> findAllUsers();

    UserEntity saveUser(UserEntity user);

	void deleteUser(UserEntity user);


}
