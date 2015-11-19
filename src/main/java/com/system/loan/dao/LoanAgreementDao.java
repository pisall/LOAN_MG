package com.system.loan.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CoDto;
import com.system.loan.dto.LoanAgreementDto;

@Service
public class LoanAgreementDao implements LoanAgreement{
	public static SessionFactory factory = null;
	
	public LoanAgreementDao(){
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

	@SuppressWarnings("unused")
	@Override
	public boolean InsertNewCustomer( LoanAgreementDto loanAgreDto) { 
		Session session = factory.getCurrentSession();
		Transaction transection = null;  
		CoDto codto =null;
		LoanAgreementDto loancus=null; 
	  
		
		try{  
				transection= session.beginTransaction();   
				Date curDate =new Date();
		        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		        String DateToStr = format.format(curDate); 
		        
				codto = (CoDto) session.get(CoDto.class,8); //get COID
				//loancus=(LoanAgreementDto)session.get(LoanAgreementDto.class, 42);// get customer ID 
				
				loanAgreDto.setCoDto(codto);  
				loanAgreDto.setCu_dtt(DateToStr);
				loanAgreDto.setCu_del_yn("Y"); 
				session.save(loanAgreDto); 
				//session.save(acodto); 
				//session.save(guDto);
			
			transection.commit(); 
		}catch(HibernateException e){
			if(transection!=null) transection.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
   
}
