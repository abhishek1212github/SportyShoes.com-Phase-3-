package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Shoes;

@Repository
public class AdminDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public boolean insertShoe(Shoes s) {
		try {
			EntityManager manager=emf.createEntityManager();
			EntityTransaction tran=manager.getTransaction();
			tran.begin();
				manager.persist(s);
			tran.commit();
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public int updateShoeDetail(Shoes s)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			Shoes shoe=manager.find(Shoes.class, s.getProductId());
			if(shoe==null)
				return 0;
			else {
				EntityTransaction tran=manager.getTransaction();
				tran.begin();
					shoe.setPrice(s.getPrice());
					manager.merge(shoe);
				tran.commit();
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Shoes> showAll(){
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createQuery("select s from Shoes s");
		List<Shoes> list=qry.getResultList();
		return list;
		
	}
	
	public int deleteShoe(int productId)
	{
		try {
			EntityManager manager=emf.createEntityManager();
			Shoes shoe=manager.find(Shoes.class, productId);
			if(shoe==null)
				return 0;
			else {
				EntityTransaction tran=manager.getTransaction();
				tran.begin();
					manager.remove(shoe);
				tran.commit();
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
	
	public Shoes findShoeById(int productId) {
		EntityManager manager=emf.createEntityManager();
		Shoes shoe=manager.find(Shoes.class,productId);
		return shoe;
		
	}
	
	
	

}
