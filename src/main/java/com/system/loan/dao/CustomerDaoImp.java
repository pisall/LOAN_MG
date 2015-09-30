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

import com.system.loan.dto.CoDto;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

@Service
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
	        tx = session.beginTransaction();
	         Query query=session.createQuery("Select C.cuID,C.cuName,C.cuSex,C.cuDOB,C.cuNationalID,C.cuAddress,C.cuPhone From CustomerDto C");
	         list=(List<CustomerDto>)query.list();	         
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<CustomerDto> listCus(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<CustomerDto> list = null;
		String filter="";
		try {
			if(paging.getSw()!=null){
				if(paging.getSw()!=""){
					filter=" and (C.cuName like '%"+paging.getSw()+"%')";
				} 
			}		
			System.out.println("fileter="+ filter);
			Query query = session.createQuery("From CustomerDto C where 1=1 " + filter);
			query.setFirstResult((paging.getPageNo()-1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list =(List<CustomerDto>) query.list();
			session.close();
		} catch (HibernateException e) {
			session.close();
			System.out.println(" there error");
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	public int totalCus(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		int cnt=0;
		String filter="";
		try{
				
			if(paging.getSw()!=null){
				if(paging.getSw()!=""){
					filter=" and (C.cuName like '%"+paging.getSw()+"%')";
				} 
			}
			Query query=session.createQuery("Select Count(C.cuID) From CustomerDto C where 1=1 "+filter);
			List<Object> list=(List<Object>)query.list();
			for(Object ob:list){
				cnt=Integer.parseInt(ob.toString());
			}
			session.close();
				
		}catch(HibernateException e){
			session.close();
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
	
	
	
	
	
}
