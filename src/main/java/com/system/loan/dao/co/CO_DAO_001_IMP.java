package com.system.loan.dao.co;


import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;

public class CO_DAO_001_IMP implements CO_DAO_001{
	private SessionFactory factory=null;
	
	public CO_DAO_001_IMP(){
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
	

	@Override
	public HashMap<String, Object> newCoLog(CO_DTO_001 CO,LOGIN_DTO_001 LOG) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> result=new HashMap<>();
		result.put("ERROR", false);
		result.put("MESSAGE", "");
		
		
		// TODO Auto-generated method stub
		System.out.println("insert");
		Session session=null;
		Transaction tx=null;
		try {
			int count=countByLogId(LOG.getLog_email());
			System.out.println("cont="+count);
			if(count>0){
				result.put("ERROR", true);
				result.put("MESSAGE", "duplicated record");
				return result;
			}
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			tx.setTimeout(5);
			CO.setLoginDTO(LOG);
			CO.setRegCo(findCoById(8));
			LOG.setCoDTO(CO);
			session.save(CO);
			session.save(LOG);
//			
			tx.commit();
			
			return result;
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("IError::CO_DAO_001(Class)::newCoLog(function)");
			e.printStackTrace();
		}
		return result;
		
	}
	@SuppressWarnings("unused")
	@Override
	public int countByLogId(String LogEmail) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(*) from LOGIN_DTO_001 where log_email=?");
			query.setString(0, LogEmail);
			Object count=query.uniqueResult();
			int intc=Integer.parseInt(count.toString());
			System.out.println("intc-"+intc);
			tx.commit();
			return intc;
			
			
		}catch(HibernateException e){
			System.out.println("IError::CO_DAO_001(Class)::countByLogId(function)");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	@Override
	public CO_DTO_001 findCoById(int id) {
		// TODO Auto-generated method stub
		 try{
			   return factory.getCurrentSession().get(CO_DTO_001.class, id);
		 }catch(Exception ex){
			   ex.printStackTrace();
		 }
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List coList() {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(co_id as co_id,"
					+ "co_first_nm as co_first_nm,"
					+ "co_last_nm as co_last_nm,"
					+ "co_sex as co_sex,"
					+ "co_brand as co_brand,"
					+ "co_phone as co_phone,"
					+ "regCo.co_id as reg_co_id,"
					+ "regCo.co_first_nm as reg_co_first_nm,"
					+ "regCo.co_last_nm as reg_co_last_nm) from CO_DTO_001 where loginDTO.enabled=true");
			
			List result=(List)query.list();
			tx.commit();
			return result;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HashMap<String, Object> findCoById2(int id) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			System.out.println(" id="+id);
			//Query query=session.createQuery("select new map(co_id as co_id) from CO_DTO_001");
			Query query=session.createQuery("select new map("
					+ "co_id as co_id,"
					+ "co_first_nm as co_first_nm,"
					+ "co_last_nm as co_last_nm,"
					+ "co_sex as co_sex,"
					+ "co_brand as co_brand,"
					+ "co_phone as co_phone,"
					+ "co_cpm_phone as co_cpm_phone,"
					+ "dob as dob,"
					+ "address as address,"
					+ "co_pb_address as co_pb_address,"
					+ "co_national_id as co_national_id,"
					+ "reg_dtt as reg_dtt,"
					+ "update_dtt as update_dtt,"
					+ "regCo.co_id as reg_co_id,"
					+ "regCo.co_first_nm as reg_co_first_nm,"
					+ "regCo.co_last_nm as reg_co_last_nm) from CO_DTO_001 where co_id=?");
			query.setInteger(0, id);
			
			HashMap<String, Object> result=new HashMap();
			List list=query.list();
			if(list.size()>0){
				result=(HashMap<String, Object>)list.get(0);
			}
			tx.commit();
			return result;
		}catch(HibernateException e){
			System.out.println("eeerorr");
			e.printStackTrace();
			
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashMap<String, Object> findLogByLogMail(String email) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(log_email as log_email,log_password as log_password,log_type as log_type,enabled as enabled) from LOGIN_DTO_001 where log_email=?");
			query.setString(0, email);
			List list=query.list();
			tx.commit();
			HashMap<String, Object> result=new HashMap<>();
			if(list.size()>0){
				 result=(HashMap<String, Object>) list.get(0);
			}
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String, Object> findCobyUserId(String userid){
		Session session=null;
		Transaction tx=null;
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(co_id as co_id,co_first_nm as co_first_nm,co_last_nm as co_last_nm) from CO_DTO_001 where loginDTO.log_email=?");
			query.setString(0, userid);
			List list=(List)query.list();
			tx.commit();
			HashMap<String, Object> user=new HashMap<>();
			if(list.size()>0){
				user=(HashMap<String, Object>) list.get(0);
				return user;
			}else{
				return null;
			}
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public HashMap<String, Object> updateEnabledUser(int id, boolean enabled) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		try{
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			CO_DTO_001 co=(CO_DTO_001)session.get(CO_DTO_001.class, id);
			co.getLoginDTO().setEnabled(enabled);
			session.update(co);

			tx.commit();
			result.put("ERROR", false);
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		result.put("ERROR", true);
		return null;
	}

}
