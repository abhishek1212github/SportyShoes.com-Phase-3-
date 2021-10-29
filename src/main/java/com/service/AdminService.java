package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Shoes;
import com.dao.AdminDao;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	public String insertShoe(Shoes s) {
		if(adminDao.insertShoe(s))
			return "New Shoe Details Inserted successfully";
		else
			return "Didn't Inserted. TRY AGAIN!";
		
	}
	
	public String updateShoeDetail(Shoes s) {
		if(adminDao.updateShoeDetail(s)>0)
			return "Details Updated Successfully";
		else
			return "Details didn't updated, TRY AGAIN!";
	}
	
	public List<Shoes> showAll(){
		return adminDao.showAll();
	}
	
	public String deleteShoe(int productId) {
		// TODO Auto-generated method stub
		if(adminDao.deleteShoe(productId)>0)
			return "Shoe record Deleted Successfully";
		else
			return "not Deleted, TRY  AGAIN!!!!!!";
	}
	
	public Shoes findShoeById(int productId) {
		return adminDao.findShoeById(productId);
	}

}
