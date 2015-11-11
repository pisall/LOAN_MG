package com.system.loan.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CustomerOfficerDto;

@Service
public class CustomerOfficerDaoImp {

	public static SessionFactory factory = null;

	public CustomerOfficerDaoImp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			factory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}


	/**
	 * List Customer Information if true return List else return null
	 */
	
	@SuppressWarnings("unchecked")
	public List<CustomerOfficerDto> listCustomerOfficer() {
		Session session = factory.getCurrentSession();
		List<CustomerOfficerDto> list = null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query query = session.createQuery("SELECT new map(CO.coID AS coID,CO.coFirstName AS coFirstName,CO.coLastName As coLastName) FROM CustomerOfficerDto CO Order By CO.coID DESC");
	
			list = (ArrayList<CustomerOfficerDto>) query.list();	
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} 
		return list;
	}

}
