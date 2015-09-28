package com.system.loan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.system.loan.dto.UserDto;

@Service
public class UserDaoImp implements UserDao {
	public static SessionFactory factory=null;
	
	//Contructor
	public UserDaoImp() {
		 try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (HibernateException e) { 
	    	  System.out.println(e.toString());
	    	    e.printStackTrace();
	    	    if (e.getCause() != null )
	    	        System.out.println(e.getCause().getMessage());
	      }
	}
	
	/**
	 * Update User Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean updateUser(UserDto user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         UserDto usr = (UserDto)session.get(UserDto.class, user.getUsID()); 
	         usr.setUsNm(user.getUsNm());
	         usr.setUsSex(user.getUsSex());
	         usr.setUsPhone(user.getUsPhone());
	         usr.setUsEmail(user.getUsEmail());
	         usr.setUsAddress(user.getUsAddress());
			 session.update(usr);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close(); 
	      }
	      return true;
	}
	/**
	 * Update User Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	public Boolean updateUser1(UserDto user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
			 session.update(user);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close(); 
	      }
	      return true;
	}
	/**
	 * Add User Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean insertUser(UserDto user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	          session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close(); 
	      }
	      return true;
	}
	/**
	 * Delete User Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean deleateUser(UserDto user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         UserDto usr = (UserDto)session.get(UserDto.class, user.getUsID()); 
			 session.delete(usr);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close(); 
	      }
	      return true;
	}
	/**
	 * List User Information 
	 * if true 
	 * 		return List
	 * else 
	 * 		return null
	 */
	@Override
	public List<UserDto> listUser() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<UserDto> list=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From UserDto");
	         list=(ArrayList<UserDto>)query.list();
	        
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return null;
	      }finally {
	         session.close(); 
	      }
		return list;
	}
	
	/**
	 * List User by id 
	 * if true 
	 * 		return List
	 * else 
	 * 		return null
	 */
	
	public List<UserDto> listSpecificUser(Integer userID) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<UserDto> user=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From MfiUserDto Where usID=?");
	         query.setParameter(0, userID);
	         user=(List<UserDto>)query.list();         
	         System.out.println(user.toString());	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return null;
	      }finally {
	         session.close(); 
	      }
		return user;
	}

}
