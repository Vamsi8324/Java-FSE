package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.service.UserService;
import com.spring.user.User;





@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class SpringController {
	@Autowired
	UserService userservice;
	
    @PostMapping("/Users")
	public User addUser(@RequestBody User user) {
		return userservice.insertEmployee(user);
	}
    @GetMapping("/message")
    public String getUsers(){
    	return "Users";
    }
    @GetMapping("/user")
    public List<User> getusers(){
    	return userservice.getAllusers();
    }
    
    

	
}

