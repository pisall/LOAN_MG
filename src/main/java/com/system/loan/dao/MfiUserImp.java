package com.system.loan.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.system.loan.dto.MfiUser;

public class MfiUserImp implements MfiUserDao {
	public static SessionFactory factory=null;
	
	
	public MfiUserImp() {
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
	public Boolean updateUser(MfiUser user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         MfiUser usr = (MfiUser)session.get(MfiUser.class, user.getUsID()); 
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
	public Boolean updateUser1(MfiUser user) {
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
	public Boolean insertUser(MfiUser user) {
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
	public Boolean deleateUser(MfiUser user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         MfiUser usr = (MfiUser)session.get(MfiUser.class, user.getUsID()); 
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
	public List<MfiUser> listUser() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<MfiUser> list=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From MfiUser");
	         list=(List<MfiUser>)query.list(); 
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
	
	public List<MfiUser> listSpecificUser(Integer userID) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<MfiUser> user=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From MfiUser Where usID=?");
	         query.setParameter(0, userID);
	         user=(List<MfiUser>)query.list();         
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
