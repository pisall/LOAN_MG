package com.system.loan.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.system.loan.dto.LoanAgreementDto;
import com.system.loan.dto.TransectionDto;

public class ApproveTransactionDao implements TransactionInterface {
	public static SessionFactory factory = null;
	
	public ApproveTransactionDao(){
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
	public 	Object Schadule_Payment(int tr_id, int cus_id) {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		Transaction tran = null;
		
		Object Data =null;
		
		try{
			tran=session.beginTransaction(); 
			
		String sql = "select   "
					
					+ "co.co_id "
					+ ",co.co_first_nm "
					+ ",co.co_last_nm "
					+ ",co.co_sex "
					+ ",co.co_national_id "
					+ ",co.co_brand "
					+ ",co.co_phone  " 
					
					
					+ ",cus.cu_id "
					+ ",cus.cu_nm "
					+ ",cus.cu_sex "
					+ ",cus.cu_phone "
					+ ",cus.cu_national_id "
					+ ",cus.cu_pawn "
					+ ",acc.ac_id"
					+ ",acc.ac_period_type "
					+ ",acc.ac_amount "
					+ ",acc.ac_start_date "
					+ ",gua.gu_nm "
					+ ",gua.gu_sex"
					+ ",gua.gu_phone "
					+ ",gua.gu_national_id "
					+ ",gua.gu_pawn "
					+ ",tran.tr_id "
					+ ",tran.pay_date "
					+ ",tran.pay_day"
					+ ",tran.tr_pay_amount "
					+ ",tran.tr_balance "
				+ "from "
					+ "mfi_customers cus "
					+ ",mfi_co co  "
					+ ",mfi_guarantor gua  "
					+ ",mfi_account acc "
					+ ",mfi_transection tran "
				+ "where 1=1 "
					+ "and cus.cu_id=gua.cu_id "
					+ "and cus.co_id=co.co_id "
					+ "and cus.cu_id=acc.cu_id "
					+ "and acc.ac_id=tran.tr_ac_id "
					+ "and cus.cu_id=?"
					+ "and tran.tr_id=?"; 
				  
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, cus_id);
			query.setParameter(1, tr_id);
			Data = query.uniqueResult();   
			tran.commit();
		}catch(HibernateException hne){
			if(tran!=null) tran.rollback();
			hne.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		return Data; 
	}
 

}
