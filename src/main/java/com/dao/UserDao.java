package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Integer>{
//	@Query("select count(e)>0 from Users e where e.email=?1 and e.password=?2")
//	public boolean  userExits(String email,int password);
	
	@Query("select count(e)>0 from Users e where e.email=?1")
	public boolean  userExits(String email);
	
}