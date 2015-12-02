package com.system.loan.dao.login;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.login.in.login_0001_in;

@Service
public class LOGIN_DAO_001_IMP implements LOGIN_DAO_001{
private SessionFactory factory=null;
	
	public LOGIN_DAO_001_IMP(){
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
		public int getUserIdByUserName(String userName) {
			// TODO Auto-generated method stub
			Session session=null;
			Transaction tx;
			try{
				session=factory.getCurrentSession();
				tx=session.beginTransaction();
				Query query=session.createQuery("select log_in from LOGIN_DTO_001 where log_email=?");
				query.setString(0, userName);
				int loIn=Integer.parseInt(query.uniqueResult().toString());
				tx.commit();
				return loIn;
			}catch(HibernateException e){
				e.printStackTrace();
			}
			return 0;
		}
	
	@Override
	public LOGIN_DTO_001 getLoginByUserName(String userName) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		LOGIN_DTO_001 login;
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			//LOGIN_DTO_001 login=(LOGIN_DTO_001)session.get(LOGIN_DTO_001.class, userName);
			Query query=session.createQuery("From LOGIN_DTO_001 where log_email=?");
			query.setString(0, userName);
			List list=(List)query.list();
			tx.commit();
			if (list.size()>0){
				login=(LOGIN_DTO_001)list.get(0);
				return login;
			}else{
				return null;
			}
			
			
			
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public HashMap<String, Object> changePassword(login_0001_in input, String userName) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result=new HashMap<>();
		Session session=null;
		Transaction tx=null;
		try{
			LOGIN_DTO_001 login=getLoginByUserName(userName);
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(input.getNewPassword());
			login.setLog_password(hashedPassword);
			session.update(login);
			tx.commit();
			result.put("ERROR", false);
			
		}catch(HibernateException e){
			e.printStackTrace();
			
		}
		result.put("ERROR", true);
		return result;
	}
	public HashMap<String,Object> changeUserName(String UserName,String NewUserName){
		HashMap<String, Object> result=new HashMap<>();
		Session session =null;
		Transaction tx=null;
		try{
			//check duplicate user name
			if(countUserByUserName(NewUserName)>0){
				result.put("ERROR", true);
				result.put("MESSAGE", "user name is already exist.");
				return result;
			}
			
			//check if user name is exist
			if(countUserByUserName(UserName)>0){
				LOGIN_DTO_001 login=getLoginByUserName(UserName);
				session=factory.getCurrentSession();
				tx=session.beginTransaction();
				login.setLog_email(NewUserName);
				session.update(login);
				tx.commit();
				result.put("ERROR", false);
				
				//check if update is effect
				if(countUserByUserName(NewUserName)>0){
					result.put("ERROR", false);
					result.put("MESSAGE", "changing user name is successful.");
				}else{
					result.put("ERROR", true);
					result.put("MESSAGE", "changing user name is fail.");
				}
				
			}else{
				result.put("ERROR", true);
				result.put("MESSAGE", "user name is not found.");
			}
			
			
			
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return result;
		
	}
	
	public void changePassword(String newpassword,String username){
		Session session=null;
		Transaction tx=null;
		try{
			LOGIN_DTO_001 login=getLoginByUserName(username);
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(newpassword);
			login.setLog_password(hashedPassword);
			session.update(login);
			tx.commit();
			System.out.println("change password complete!");
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}
	public int countUserByUserName(String userName){
		Session session=null;
		Transaction tx=null;
		int rcnt=0;
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createSQLQuery("select count(*) cnt from mfi_login where log_email=?");
			query.setString(0, userName);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			HashMap<String, Object> result=(HashMap<String, Object>)query.uniqueResult();
			tx.commit();
			rcnt=Integer.parseInt(result.get("cnt").toString());
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return rcnt;
	}
	
}


