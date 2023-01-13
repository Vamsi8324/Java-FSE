package com.spring.service;

import java.util.List;


import com.spring.user.User;



public interface UserService {

	User insertEmployee(User user);

	List<User> getAllusers();

}
