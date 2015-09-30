package com.system.loan.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.CustomerOfficerDto;

@Service
public class CustomerOfficerDaoImp {

	public static SessionFactory factory = null;

	public CustomerOfficerDaoImp() {
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
	 * List Customer Information if true return List else return null
	 */
	
	public List<CustomerOfficerDto> listCustomerOfficer() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<CustomerOfficerDto> list = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("From CustomerOfficerDto");
			list = (ArrayList<CustomerOfficerDto>) query.list();		
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return list;
	}

}
