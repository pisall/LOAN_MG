package com.system.loan.dao;

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
import org.springframework.transaction.annotation.Transactional;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

@Service
public class CustomerDaoImp implements CustomerDao {
	public static SessionFactory factory = null;
	public CustomerDaoImp() {
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
	 * Update Customer Information if true return true else return false
	 */
	@Override
	
	public Boolean updateCustomer(CustomerDto customer) {
		Session session = factory.getCurrentSession();
		try {
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			session.update(cus);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

	/**
	 * Add Customer Information if true return true else return false
	 */
	@Override
	
	public Boolean insertCustomer(CustomerDto Customer) {
		Session session = factory.getCurrentSession();
		try {
			session.save(Customer);
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Delete Customer Information if true return true else return false
	 */
	@Override
	public Boolean deleteCustomer(CustomerDto customer) {
		Session session = factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			cus.setCuDelYn(customer.getCuDelYn());
			session.update(cus);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} 
		return true;
	}

	/**
	 * List Customer Information if true return List else return null
	 */
	@Override
	public List<CustomerDto> listCustomer(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		List<CustomerDto> list = null;
		String filter = "";
		String orderRec = " Order By C.cuID DESC";
		Transaction tx=null;
		try {
			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(C.cuID as string) like '%" 
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuName) like '%"
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuPhone) like '%"
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuAddress) like '%"
							+ paging.getSw().toLowerCase() + "%' ";
				}
			}
			tx=session.beginTransaction();
			Query query = session
					.createQuery("From CustomerDto C where 1=1 And C.cuDelYn='N'  And cast(C.customerOfficerDto.coID as text) Like  ?  "
							+ filter + orderRec);
			query.setString(0, "%"+coID+"%");
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list = (List<CustomerDto>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	public int totalCus(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int cnt = 0;
		String filter = "";
		Transaction tx=null;
		try {

			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(C.cuID as string) like '%" 
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuName) like '%"
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuPhone) like '%"
							+ paging.getSw().toLowerCase() + "%' Or lower(C.cuAddress) like '%"
							+ paging.getSw().toLowerCase() + "%' ";
				}
			}
			tx=session.beginTransaction();
			Query query = session.createQuery(
					"Select Count(C.cuID) From CustomerDto C where 1=1 and C.cuDelYn='N' And cast(C.customerOfficerDto.coID as text) like ?  "
							+ filter);

			query.setString(0, "%"+coID+"%");
			List<Object> list = (List<Object>) query.list();
			for (Object ob : list) {
				cnt = Integer.parseInt(ob.toString());
			}
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		} 
		return cnt;
	}

	/**
	 * List Customer by id if true return List else return null
	 */
	
	public CustomerDto listSpecificCustomer(String cuID) {
		Session session = factory.getCurrentSession();
		CustomerDto cus = null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			cus =(CustomerDto) session.get(CustomerDto.class, Integer.parseInt(cuID));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return cus;
	}

}
