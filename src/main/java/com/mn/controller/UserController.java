package com.mn.controller;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mn.entities.UserEntity;
import com.mn.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired

	private IUserService userService;

	// -------------------Create user-------------------------------------------

	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public void createUser(@RequestBody UserEntity user) {
	
			userService.saveUser(user);
		
	}

	// ------------------- Update user
	// ------------------------------------------------

	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserEntity user) {
		logger.info("Updating user with id {}", id);

		UserEntity users = userService.findById(id);
		if (users == null) {
			logger.error("Unable to update. user with id {} not found.", id);
			return new ResponseEntity("Unable to upate. user with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

		user.setFirstName(user.getFirstName());
		user.setLastName(user .getLastName());
		user.setEmail(user.getEmail());

		
        userService.saveUser(user);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		UserEntity user = userService.findById(id);
		if (user == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity("Unable to delete. User with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(user);
		return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/allusers", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> listAllUsers() {
		// List<ClientEntity> users = userService.findAllUsers();
		List<UserEntity> users = new ArrayList<UserEntity>();
		users=userService.findAllUsers();
		logger.info("result size is: "+users.size());
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		UserEntity user = userService.findById(id);
		if (user  == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity("User with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserEntity>(user , HttpStatus.OK);
	}	

}
