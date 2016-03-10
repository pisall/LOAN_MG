package com.system.loan.sys.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.co.in.co_0001_in;
@Service
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
			Query query=session.createSQLQuery("select count(*) cnt from mfi_co co where co.co_id=co.reg_co_id");
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
		String regDate="";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		regDate=dateFormat.format(date);
		
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			result.put("ERROR", false);
			
			//check if user has been create already
			if(isDuplicate){
				result.put("ERROR", true);
				result.put("MESSAGE","User has been created already.");
				tx.rollback();
				return result;
			}else{
				strUserName=input.getLog_email();
				
				//user name is not null
				if(strUserName.length()==0){
					result.put("ERROR", true);
					result.put("MESSAGE","User name is empty. please input again.");
					tx.rollback();
					return result;
				}
				//check if duplicate user name
				query=session.createSQLQuery("select count(*) cnt from mfi_login where log_email=?");
				query.setString(0, strUserName);
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				countUser=Integer.parseInt(((HashMap<String,Object>)query.uniqueResult()).get("cnt").toString());
				if(countUser>0){
					result.put("ERROR", true);
					result.put("MESSAGE","User name is already exist.");
					tx.rollback();
					return result;
				}
				
				//check if empty password
				String pass="";
				pass=input.getLog_password();
				String confirpass=input.getConfirm_password();
				if(pass.length()==0){
					result.put("ERROR", true);
					result.put("MESSAGE","Password can't be empty,please input password.");
					tx.rollback();
					return result;
				}
				//check if password is match
				if(!input.getLog_password().equals(input.getLog_password())){
					result.put("ERROR", true);
					result.put("MESSAGE","Password is not match. please try again.");
					tx.rollback();
					return result;
				}
				
				CO_DTO_001 co=new CO_DTO_001();
				LOGIN_DTO_001 log=new LOGIN_DTO_001();
				
				co.setAddress(input.getAddress());
				co.setCo_brand(input.getCo_brand());
				co.setCo_cpm_phone(input.getCo_cpm_phone());
				co.setCo_first_nm(input.getCo_first_nm());
				co.setCo_last_nm(input.getCo_last_nm());
				co.setCo_national_id(input.getCo_national_id());
				co.setCo_pb_address(input.getCo_pb_address());
				co.setCo_phone(input.getCo_phone());
				co.setCo_sex(input.getCo_sex());
				co.setDob(input.getDob());
				co.setReg_dtt(regDate);
				co.setRegCo(co);
				
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				
				String passEn=passwordEncoder.encode(input.getLog_password());
				
				log.setLog_password(passEn);
				log.setLog_email(input.getLog_email());
				log.setLog_type("ROLE_ADMIN");
				log.setEnabled(true);
				
				log.setCoDTO(co);
				session.save(co);
				session.save(log);
				tx.commit();
				result.put("ERROR", false);
				
			}
			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
		
		
		return result;
		
		
		
	}
	

}
