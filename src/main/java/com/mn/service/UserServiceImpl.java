package com.mn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mn.dao.UserDao;
import com.mn.entities.UserEntity;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public UserEntity findById(long id) {
		UserEntity user=userDao.findById(id);
		return user ;
	}

	@Override
	public List<UserEntity> findAllUsers() {
		return (List<UserEntity>)userDao.findAll();
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		return userDao.save(user);
		
	}

	@Override
	public void deleteUser(UserEntity user) {
		userDao.delete(user);	
		
	}
	
	

}
