package com.mn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mn.dao.UserDao;
import com.mn.entities.User;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User findById(long id) {
		User user=userDao.findById(id);
		return user ;
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>)userDao.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
		
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);	
		
	}
	
	

}
