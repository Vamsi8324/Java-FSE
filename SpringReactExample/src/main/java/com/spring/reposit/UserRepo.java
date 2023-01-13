package com.spring.reposit;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.user.User;



public interface UserRepo extends JpaRepository<User,Integer> {

}