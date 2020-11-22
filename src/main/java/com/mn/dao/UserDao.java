package com.mn.dao;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import com.mn.entities.UserEntity;

@Transactional
public interface UserDao extends CrudRepository<UserEntity, Long> {

	public UserEntity findById(long id);
	
}
