/**
 * 
 */
package com.system.loan.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.system.loan.dto.MfiCoDto;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */
public class MfiCoDaoImp implements MfiCoDao {
	public static SessionFactory factory = null;

	public MfiCoDaoImp() {
		// TODO Auto-generated constructor stub

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			if (e.getCause() != null)
				System.out.println(e.getCause().getMessage());
		}
	}

	@Override
	public List<MfiCoDto> listCo(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<MfiCoDto> list = null;
		try {
		Query query = session.createQuery("from MfiCoDto M where 1=1 ");
		query.setFirstResult(paging.getPageNo());
		query.setMaxResults(paging.getPcnt());
			list =(List<MfiCoDto>) query.list();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
		return list;
	}

}
