package com.system.loan.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.LoanApprovalDto;

@Service
public class LoanApprovalDao implements LoanApprovalInterface{

	
public static SessionFactory factory = null;
	
	public LoanApprovalDao(){
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
	public boolean LoanApro_Insert(LoanApprovalDto loaApro) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		try{
			tran=session.beginTransaction();
			Date date = new Date();
			SimpleDateFormat formart = new SimpleDateFormat("yyyyMMddHHmmss");
			String datetime = formart.format(date);
			loaApro.setTr_dtt(datetime);
			session.save(loaApro);
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean TranSac_Update(int tr_id, String tr_type,int cu_id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		String sql1="";
		
		try{
			tran=session.beginTransaction();
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String datetime = format.format(date); 
			
			
			if(tr_type.equals("2")){
				sql1="update mfi_transection set tr_stts='2' where (tr_cu_id='"+cu_id+"' and tr_stts='3') OR (tr_id='"+tr_id+"' and tr_stts='1')";
			}else if(tr_type.equals("4")){
				sql1="update mfi_transection set tr_stts='4' where tr_cu_id='"+cu_id+"' and tr_stts in('1','2','3')";
			}else if(tr_type.equals("5")){
				sql1="update mfi_transection set tr_stts='1' where (tr_cu_id='"+cu_id+"' and  tr_id='"+tr_id+"') ";
			}
			SQLQuery query = session.createSQLQuery(sql1);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			//query.setParameter(0, cu_id);
			//query.setParameter(1, tr_id);
			query.executeUpdate(); 
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public 	boolean updateLoanApprove(LoanApprovalDto approve) {		
		Session session = factory.getCurrentSession();
		Transaction tran = null;		
		try{
			tran=session.beginTransaction();
			LoanApprovalDto app=(LoanApprovalDto)session.get(LoanApprovalDto.class,approve.getTr_id());		
			app.setPaid_amount(approve.getPaid_amount());
			app.setPre_pay(approve.getPre_pay());
			app.setAmount_fine(approve.getAmount_fine());
			app.setDays_late(approve.getDays_late());
			
			System.out.println(app.toString());
			
			tran.commit();
		}catch(HibernateException hne){
			if(tran!=null) tran.rollback();
			hne.printStackTrace();
			return false;
		}
		return true; 
	}



	
	

}
