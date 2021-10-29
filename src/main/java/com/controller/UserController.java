package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Shoes;
import com.service.AdminService;
import com.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	
	//http://localhost:9090/user/showAllShoes
	@GetMapping(value="showAllShoes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Shoes> showAll(){
		return adminService.showAll();
	}
	
	//http://localhost:9090/user/findUser/abhi@gmail.com
	@GetMapping(value="findUser/{email}")
	public String  userExits(@PathVariable("email") String email) {
		return userService.userExits(email);
	}
	
	
	//http://localhost:9090/user/signin?email=abhi@gmail.com&password=12345
//	@GetMapping(value="SignIn")
//	public String SignIn(@RequestParam("email") String email,@RequestParam("password") int password )
//	{
//			return userService.userExits(email,password);
//		}

	

}
