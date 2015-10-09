/**
 * 
 */
package com.system.loan.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.loan.dto.CoDto;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */
@Service
@Repository
@Transactional
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
		String filter="";
		try {
			if(paging.getSw()!=null){
				if(paging.getSw()!=""){
					filter=" and (M.coFirstNm like '%"+ paging.getSw() + "%' or M.coLastNm like '%"+paging.getSw()+"%')";
				} 
			}
			
			System.out.println("fileter="+ filter);
			Query query = session.createQuery("from CoDto M where 1=1 " + filter);
			query.setFirstResult((paging.getPageNo()-1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list =(List<CoDto>) query.list();
		} catch (HibernateException e) {
			System.out.println(" there error");
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@Override
	public int totalRecord(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		int cnt=0;
		String filter="";
		try{
				
			if(paging.getSw()!=null){
				if(paging.getSw()!=""){
					filter=" and (M.coFirstNm like '%"+ paging.getSw() + "%' or M.coLastNm like '%"+paging.getSw()+"%')";
				} 
			}
			Query query=session.createQuery("select count(M.coId) from CoDto M where 1=1 "+filter);
			List<Object> list=(List<Object>)query.list();
			for(Object ob:list){
				cnt=Integer.parseInt(ob.toString());
			}
			
		}catch(HibernateException e){
			
			System.out.println(" error total remord");
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return cnt;
	}
	
	public void testjoin(){
		Session session=factory.openSession();
		try{
			
			Query query=session.createQuery("select M.codto.coFirstNm from custDto M where M.cuId=1");
			List<String> list=(List<String>)query.list();
			for(String in:list){
				System.out.println("inte ="+in);
			}
			System.out.println("size="+ list.size());
			
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
	}
	
	public String testNativeSql(){
		String sql="select nextval('sq_co_id')";
		Session session=factory.openSession();
		try{
			SQLQuery query=session.createSQLQuery(sql);
			 Object ob=query.uniqueResult();
			 String strOb=ob.toString();
			 int intOb=Integer.parseInt(strOb);
//			for(Integer s:list){
//				System.out.println(s);
//			}
			 
			 /*for (Iterator iterator = list.iterator(); iterator.hasNext(); )
			    {
				 Object ob=iterator.next();
				 String strOb=ob.toString();
			        System.out.println(strOb);
			        
			    }*/
			 
			 System.out.println(intOb);
			
		}catch(HibernateException e){
			
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		return "yyy";
	}
	
	public List testJson() {
		Session session=factory.openSession();
		List list=null;
		
		try{
			Query query=session.createQuery("select new map(coId as coId,dob as dob) from CoDto");
			 list=query.list();
		}catch(HibernateException e){
			session.close();
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
		
	}

}
