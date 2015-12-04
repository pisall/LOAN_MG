package com.system.loan.dao;

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

@Service
public class ApproveTransactionDao implements TransactionInterface {
	public static SessionFactory factory = null;
	
	public ApproveTransactionDao(){
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
	public 	Object Schadule_Payment(int tr_id, int cus_id) {
		// TODO Auto-generated method stub
		
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		
		Object Data =null;
		
		try{
			tran=session.beginTransaction(); 
			
		String sql = "select"				
					+ " co.co_id "
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
					+",(to_date(pay_date,'YYYYMMDD24H') - (SELECT to_date(pay_date,'YYYYMMDD24H') FROM mfi_transection WHERE tr_cu_id="+cus_id+" and tr_stts='3' ORDER BY pay_date ASC LIMIT 1)) as day_late "
					+",(SELECT count(tr_id) from mfi_transection WHERE tr_stts='3' and tr_cu_id="+cus_id+") as total_tr "
				+ " from "
					+ "mfi_customers cus "
					+ ",mfi_co co  "
					+ ",mfi_guarantor gua  "
					+ ",mfi_account acc "
					+ ",mfi_transection tran "
				+ " where 1=1 "
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
		}
		return Data; 
	}
 

}
