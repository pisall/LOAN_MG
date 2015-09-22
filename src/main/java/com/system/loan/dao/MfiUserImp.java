package com.system.loan.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpRequest;

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

	@Override
	public Boolean updateUser(MfiUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertUser(MfiUser user) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      Boolean status = true;
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

	@Override
	public Boolean deleateUser(MfiUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MfiUser> listUser() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<MfiUser> list=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("SELECT u From MfiUser u");
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

}
