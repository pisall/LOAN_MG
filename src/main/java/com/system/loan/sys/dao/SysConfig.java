package com.system.loan.sys.dao;


import java.util.HashMap;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	
	
	public HashMap<String, Object> addSysUser(co_0001_in input){
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		boolean isDuplicate=isExist();
		String strUserName="";
		Query query=null;
		int countUser=0;
		
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			result.put("ERROR", false);
			
			//check if user has been create already
			if(isDuplicate){
				result.put("ERROR", true);
				result.put("MESSAGE","User has been created already.");
				return result;
			}else{
				strUserName=input.getLog_email();
				
				//user name is not null
				if(strUserName.length()==0){
					result.put("ERROR", true);
					result.put("MESSAGE","User name is empty. please input again.");
					return result;
				}
				//check if duplicate user name
				query=session.createSQLQuery("select count(*) cnt from mfi_login where log_email='?'");
				query.setString(0, strUserName);
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				countUser=Integer.parseInt(((HashMap<String,Object>)query.uniqueResult()).get("cnt").toString());
				if(countUser>0){
					result.put("ERROR", true);
					result.put("MESSAGE","User name is already exist.");
					return result;
				}
				
				//check if empty password
				String pass="";
				pass=input.getLog_password();
				String confirpass=input.getConfirm_password();
				if(pass.length()==0){
					result.put("ERROR", true);
					result.put("MESSAGE","Password can't be empty,please input password.");
					return result;
				}
				//check if password is match
				if(!input.getLog_password().equals(input.getLog_password())){
					result.put("ERROR", true);
					result.put("MESSAGE","Password is not match. please try again.");
					return result;
				}
				
				
			}
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		
		return result;
		
		
		
	}
	

}
