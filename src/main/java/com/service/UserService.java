package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userRepository;
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	public String  userExits(String email) {
		if(userRepository.userExits(email))
			return "User Exits";
		return "not exits";
		
	}
	
//
//	public String userExits(String email, int password) {
//		// TODO Auto-generated method stub
//		if(userRepository.userExits(email,password))
//			return "User Exits";
//		return "not exits";
//	}
	

	

}
