package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.reposit.UserRepo;
import com.spring.user.User;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
	UserRepo userRepo;
	
	public User insertEmployee(User user) {
		
		return userRepo.save(user);
	}
	
	public List<User> getAllusers() {
		
		return userRepo.findAll();
	}

}
