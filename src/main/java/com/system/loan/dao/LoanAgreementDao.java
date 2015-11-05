package com.system.loan.dao;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.CoDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.LoanAgreementDto;
import com.system.loan.dto.TransectionDto;

public class LoanAgreementDao implements LoanAgreement{
	public static SessionFactory factory = null;
	
	public LoanAgreementDao(){
		try{
			factory = new Configuration().configure().buildSessionFactory(); 
		}catch(HibernateException e){
			System.out.println(e.toString());
			e.printStackTrace();
			if(e.getCause()!=null){
				System.out.println(e.getCause().getMessage());
			}
		}
	}

	@Override
	public boolean InsertNewCustomer( LoanAgreementDto loanAgreDto) { 
		Session session = factory.openSession(); 
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
		}finally{
			session.close();
		}
		return true;
	}
   
}
