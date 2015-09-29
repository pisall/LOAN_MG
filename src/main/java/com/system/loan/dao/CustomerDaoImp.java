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

import com.system.loan.dto.CustomerDto;

@Service("customerService")
public class CustomerDaoImp implements CustomerDao {

public static SessionFactory factory=null;
	

	public  CustomerDaoImp() {		
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
	 * Update Customer Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean updateCustomer(CustomerDto customer) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         CustomerDto cus = (CustomerDto)session.get(CustomerDto.class, customer.getCuID()); 
	        
			 session.update(cus);
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
	 * Update Customer Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	public Boolean updateCustomer1(CustomerDto Customer) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
			 session.update(Customer);
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
	 * Add Customer Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean insertCustomer(CustomerDto Customer) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	          session.save(Customer); 
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
	 * Delete Customer Information 
	 * if true 
	 * 		return true
	 * else 
	 * 		return false
	 */
	@Override
	public Boolean deleateCustomer(CustomerDto customer) {
		 Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction(); 
	         CustomerDto usr = (CustomerDto)session.get(CustomerDto.class, customer.getCuID()); 
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
	 * List Customer Information 
	 * if true 
	 * 		return List
	 * else 
	 * 		return null
	 */
	@Override
	public List<CustomerDto> listCustomer() {
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<CustomerDto> list=null;
	      try{
	        
	         Query query=session.createQuery("From CustomerDto");
	         list=(ArrayList<CustomerDto>)query.list();
	        
	       
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
	 * List Customer by id 
	 * if true 
	 * 		return List
	 * else 
	 * 		return null
	 */
	
	public List<CustomerDto> listSpecificCustomer(Integer CustomerID) {
	      Session session = factory.openSession();
	      Transaction tx = null;
	      List<CustomerDto> Customer=null;
	      try{
	         tx = session.beginTransaction();
	         Query query=session.createQuery("From MfiCustomerDto Where usID=?");
	         query.setParameter(0, CustomerID);
	         Customer=(List<CustomerDto>)query.list();         
	         System.out.println(Customer.toString());	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return null;
	      }finally {
	         session.close(); 
	      }
		return Customer;
	}
}
