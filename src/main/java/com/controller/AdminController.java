package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Shoes;
import com.bean.Users;
import com.service.AdminService;
import com.service.UserService;

@RestController
@RequestMapping("admin")
public class AdminController{
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	//http://localhost:9090/admin/signin?email=admin@gmail.com&password=admin
	@GetMapping(value="signin")
	public String AdminSignIn(@RequestParam("email") String email,@RequestParam("password") String password) {
		if(email.equals("admin@gmail.com") && password.equals("admin"))
			return "Admin Login success";
		else
			return "Admin login failed. TRY AGAIN!";
		
	}
	//http://localhost:9090/admin/addNewShoe
	@PostMapping(value="addNewShoe",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertShoe(@RequestBody Shoes s) {
		return adminService.insertShoe(s);
	}
	
	//http://localhost:9090/admin/updateShoeDetail
	@PutMapping(value="updateShoeDetail",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateShoeDetail(@RequestBody Shoes s) {
		return adminService.updateShoeDetail(s);
	}
	//http://localhost:9090/admin/showAllShoes
	@GetMapping(value="showAllShoes",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Shoes> showAll(){
		return adminService.showAll();
	}
	
	//http://localhost:9090/admin/deleteShoeRecord/101
	@DeleteMapping(value="deleteShoeRecord/{productId}")
	public String deleteShoe(@PathVariable("productId") int productId) {
		return adminService.deleteShoe(productId);
	}
	//http://localhost:9090/admin/findShoeRecord/104
	@GetMapping(value="findShoeRecord/{productId}")
	public Shoes findShoeById(@PathVariable("productId") int productId) {
		return adminService.findShoeById(productId);
		
	}
	
	//http://localhost:9090/admin/allUsers
	@GetMapping(value="allUsers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
		
	}

}
