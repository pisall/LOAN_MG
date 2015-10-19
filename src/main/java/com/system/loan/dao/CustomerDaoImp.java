package com.system.loan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.loan.config.HibernateSessionFactory;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

@Service
@Repository
public class CustomerDaoImp implements CustomerDao {

	//public static SessionFactory factory = null;
	@Autowired
	HibernateSessionFactory factory;
	
	/**
	 * Update Customer Information if true return true else return false
	 */
	@Override
	@Transactional
	public Boolean updateCustomer(CustomerDto customer) {
		Session session = factory.getSessionFactory().openSession();
		try {
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			session.update(cus);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * Add Customer Information if true return true else return false
	 */
	@Override
	@Transactional
	public Boolean insertCustomer(CustomerDto Customer) {
		Session session = factory.getSessionFactory().openSession();
		try {
			session.save(Customer);
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * Delete Customer Information if true return true else return false
	 */
	@Override
	@Transactional
	public Boolean deleteCustomer(CustomerDto customer) {
		Session session = factory.getSessionFactory().openSession();
		try {
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			cus.setCuDelYn(customer.getCuDelYn());
			System.out.println("Customer yn"+cus.getCuDelYn()+"===========================Customer ID+="+customer.getCuID());
			session.saveOrUpdate(cus);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return true;
	}

	/**
	 * List Customer Information if true return List else return null
	 */
	@Override
	@Transactional
	public List<CustomerDto> listCustomer(pagingDto paging, int coID) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		List<CustomerDto> list = null;
		String filter = "";
		String orderRec = " Order By C.cuID DESC";
		try {
			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(C.cuID as string) like '%" + paging.getSw() + "%' Or C.cuName like '%"
							+ paging.getSw() + "%'";
				}
			}

			Query query = session
					.createQuery("From CustomerDto C where 1=1 And C.cuDelYn='N' And C.customerOfficerDto.coID=?  "
							+ filter + orderRec);
			query.setInteger(0, coID);
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list = (List<CustomerDto>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	@Transactional
	public int totalCus(pagingDto paging, int coID) {
		// TODO Auto-generated method stub
		Session session = factory.getSessionFactory().openSession();
		int cnt = 0;
		String filter = "";
		try {

			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and (C.cuName like '%" + paging.getSw() + "%')";
				}
			}
			Query query = session.createQuery(
					"Select Count(C.cuID) From CustomerDto C where 1=1 and C.cuDelYn='N' And C.customerOfficerDto.coID=?  "
							+ filter);

			query.setInteger(0, coID);
			List<Object> list = (List<Object>) query.list();
			for (Object ob : list) {
				cnt = Integer.parseInt(ob.toString());
			}
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return cnt;
	}

	/**
	 * List Customer by id if true return List else return null
	 */
	@Transactional
	public CustomerDto listSpecificCustomer(String cuID) {
		Session session = factory.getSessionFactory().openSession();
		CustomerDto cus = null;
		try {
			cus = session.get(CustomerDto.class, Integer.parseInt(cuID));
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return cus;
	}

}
