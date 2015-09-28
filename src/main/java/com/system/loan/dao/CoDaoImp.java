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

import com.system.loan.dto.CoDto;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */
public class CoDaoImp implements CoDao {
	public static SessionFactory factory = null;
	
	//Constructor
	public CoDaoImp() {
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
	public List<CoDto> listCo(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		List<CoDto> list = null;
		try {
		Query query = session.createQuery("from MfiCoDto M where 1=1 ");
		query.setFirstResult(paging.getPageNo());
		query.setMaxResults(paging.getPcnt());
			list =(List<CoDto>) query.list();
			session.close();
		} catch (HibernateException e) {
			session.close();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int totalRecord(String filter) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		int cnt=0;
		try{
			Query query=session.createQuery("select count(M.coId) from MfiCoDto M where 1=1 "+filter);
			List<Object> list=(List<Object>)query.list();
			for(Object ob:list){
				cnt=Integer.parseInt(ob.toString());
			}
				
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return cnt;
	}

}
