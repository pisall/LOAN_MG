package com.system.loan.dao;

import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

@Service
@Repository
@Transactional
public class CustomerDaoImp implements CustomerDao {

	public static SessionFactory factory = null;

	public CustomerDaoImp() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			if (e.getCause() != null)
				System.out.println(e.getCause().getMessage());
		}
	}

	/**
	 * Update Customer Information if true return true else return false
	 */
	@Override
	public Boolean updateCustomer(CustomerDto customer) {
		Session session = factory.openSession();
		try {
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			session.update(cus);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.flush();
			session.close();
		}
		return true;
	}

	/**
	 * Update Customer Information if true return true else return false
	 */
	public Boolean updateCustomer1(CustomerDto Customer) {
		Session session = factory.openSession();
		try {
			session.update(Customer);	
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	/**
	 * Add Customer Information if true return true else return false
	 */
	@Override
	public Boolean insertCustomer(CustomerDto Customer) {
		Session session = factory.openSession();	
		try {			
			session.save(Customer);		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.flush();
			session.close();
		}
		return true;
	}

	/**
	 * Delete Customer Information if true return true else return false
	 */
	@Override
	public Boolean deleateCustomer(CustomerDto customer) {
		Session session = factory.openSession();
		try {		
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			cus.setCuDelYn("Y");
			session.update(cus);		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.flush();
			session.close();
		}
		return true;
	}

	/**
	 * List Customer Information if true return List else return null
	 */
	@Override
	public List<CustomerDto> listCustomer(pagingDto paging,int coID ) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<CustomerDto> list = null;
		String filter = "";
		String orderRec = " Order By C.cuID DESC";
		try {
			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(C.cuID as string) like '%" + paging.getSw() + "%' Or C.cuName like '%" + paging.getSw() + "%'";
				}
			}
	
			Query query = session
					.createQuery("From CustomerDto C where 1=1 And C.cuDelYn='N' And C.customerOfficerDto.coID=?  " + filter + orderRec);
			query.setInteger(0,coID);
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list = (List<CustomerDto>) query.list();

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
		return list;
	}
	
	
	public int totalCus(pagingDto paging,int coID) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		int cnt = 0;
		String filter = "";
		try {

			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and (C.cuName like '%" + paging.getSw() + "%')";
				}
			}
			Query query = session.createQuery(
					"Select Count(C.cuID) From CustomerDto C where 1=1 and C.cuDelYn='N' And C.customerOfficerDto.coID=?  " + filter);
		
			query.setInteger(0,coID);
			List<Object> list = (List<Object>) query.list();
			for (Object ob : list) {
				cnt = Integer.parseInt(ob.toString());
			}

		} catch (HibernateException e) {			
			System.out.println(" error total remord");
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return cnt;
	}
	
	/**
	 * List Customer by id 
	 * if true 
	 * 		return List
	 * else 
	 * 		return null
	 */
	
	public CustomerDto listSpecificCustomer(String cuID) {
	      Session session = factory.openSession();
	      CustomerDto cus=null;
	      try{        
	          cus=session.get(CustomerDto.class, Integer.parseInt(cuID));
	      }catch (HibernateException e) {
	         e.printStackTrace(); 
	         return null;
	      }finally {
	    	 session.flush();
	         session.close(); 
	      }
		return cus;
	}

	

}
