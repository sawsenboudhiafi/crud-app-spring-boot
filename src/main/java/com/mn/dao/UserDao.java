package com.mn.dao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.mn.entities.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findById(long id);
	
}
