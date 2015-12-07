package com.system.loan.sys.dao;


import java.util.HashMap;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.system.loan.dto.co.in.co_0001_in;

public class SysConfig {
	public static SessionFactory factory = null;
	public SysConfig(){
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
	
	public boolean isExist(){
		Session session =null;
		boolean isExist=false;
		try{
			session=factory.openSession();
			Query query=session.createSQLQuery("select count(*) cnt from mfi_co where co_id=reg_co_id");
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			
			HashMap<String, Object> hashResult=(HashMap<String, Object>)query.uniqueResult();
			int cnt=Integer.parseInt(hashResult.get("cnt").toString());
			
			if(session.isOpen()){
				session.close();
			}
			
			if(cnt>0){
				isExist=true;
			}else{
				isExist=false;
			}
			
		}catch(HibernateException e){
			if(session.isOpen()){
				session.close();
			}
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		
		if(session.isOpen()){
			session.close();
		}
		return isExist;
		
	}
	
	public void addSysUser(co_0001_in input){
		
		
		
	}
	

}
