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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<CustomerOfficerDto> listCustomerOfficer(String brand) {
		Session session = factory.getCurrentSession();
		List<CustomerOfficerDto> list = null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query query = session.createQuery("SELECT new map(CO.coID AS coID,CO.coName AS coName) FROM CustomerOfficerDto CO Where CO.coBrand=? ");
					query.setString(0, brand);
			list = (ArrayList<CustomerOfficerDto>) query.list();	
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} 
		return list;
	}

}
