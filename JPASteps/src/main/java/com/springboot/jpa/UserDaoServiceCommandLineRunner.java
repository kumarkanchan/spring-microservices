package com.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpa.entity.User;
import com.springboot.jpa.service.UserDAOService;
import com.springboot.jpa.service.UserRepository;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	/*
	 * @Autowired private UserDAOService userDAOService;
	 * 
	 * @Override public void run(String... args) throws Exception { User user = new
	 * User("Jack", "Admin");
	 * 
	 * // New User is created : User [id=1, name=Jack, role=Admin]
	 * 
	 * long insert = userDAOService.insert(user); log.info("New User is created : "
	 * + user);
	 * 
	 * }
	 */	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Joe", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);


		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);

		
		List<User> users = userRepository.findAll();
		log.info("New User is created : " + user);

	}

}
