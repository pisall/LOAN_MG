package com.system.loan.dao;

import java.util.Iterator;
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

	@Override
	public Boolean updateUser(MfiUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertUser(MfiUser user) {
	
		return null;
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
	      List list=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From MfiUser");
	         list=query.list();
	         for (Iterator iterator = 
                     list.iterator(); iterator.hasNext();){
				      MfiUser user = (MfiUser) iterator.next(); 
				      System.out.print("User ID: " + user.getUsID()); 				   
				   }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	     
	      }finally {
	         session.close(); 
	      }
		return null;
	}

}
