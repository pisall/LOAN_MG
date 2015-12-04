package com.system.loan.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.system.loan.dto.TransectionDto; 

@Service
public class TransectionDao implements Trandsection {
public static SessionFactory factory = null;
	
	public TransectionDao(){
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
	public boolean InsertTransection(TransectionDto tranDto) {
		Session session = factory.getCurrentSession();
		 
		Date datetime = new Date();
		SimpleDateFormat date = new SimpleDateFormat();
		Transaction tx=null;
		try{
		tx=session.beginTransaction();
		String nowDate = date.format(datetime);
		// get data from object 
		tranDto.getTr_origin_amount();
		tranDto.getTr_save_payment();
		tranDto.getTr_pay_amount();
		tranDto.setTr_stts("1"); //1.pending,2.completed,3.area,4.fullcompleted 
		tranDto.getTr_total_rate();
		tranDto.setTr_dtt(nowDate);
		
		session.save(tranDto);
		tx.commit();
		}catch(HibernateException  e){
			tx.rollback();
			e.printStackTrace();
		}
		return true;
	}

	// select transaction list
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TransectionDto> ShowReport(int cus_id) {
		// TODO Auto-generated method stub
		//factory = new Configuration().configure().buildSessionFactory(); 
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		List listData =null;
		try{
			tran=session.beginTransaction(); 
			
		String sql = "select  "
					+ "c.co_id,"
					+ " c.co_first_nm,"
					+ " c.co_last_nm,"
					+ " c.co_sex, "
					+ " c.co_brand,"
					+ " c.co_national_id,"
					+ " c.co_phone,"
					+ " c.co_cpm_phone,"
					+ " cus.cu_id,"
					+ " cus.cu_nm,"
					+ " cus.cu_phone,"
					+ " cus.cu_dtt,"
					+ " cus.cu_address,"
					+ " acc.ac_amount,"
					+ " acc.ac_rate,"
					+ " acc.ac_start_date,"
					+ " acc.ac_end_date,"
					+ " acc.ac_period_type,"
					+ " gua.gu_id,"
					+ " gua.gu_nm,"
					+ " gua.gu_sex,"
					+ " gua.gu_phone,"
					+ " gua.gu_address,"
					+ " trn.tr_id,"
					+ " to_char(to_date(trn.pay_date, 'YYYYMMDDHH24MISS'),'DD-MM-YYYY') As date_pay , "
					+ " trn.pay_day,"
					+ " trn.tr_origin_amount,"
					+ " trn.tr_balance,"
					+ " trn.tr_pay_amount,"
					+ " trn.tr_save_payment,"
					+ " trn.tr_stts,"
					+ " trn.tr_total_rate,"
					+ " trn.tr_ac_id"
					
					+ " from "
						+ " mfi_co c,"
						+ " mfi_customers cus,"
						+ " mfi_transection trn ,"
						+ " mfi_account acc,"
						+ " mfi_guarantor gua "
					
				    + "where 1=1"
					
					+ "and c.co_id=cus.co_id "
					+ "and cus.cu_id=gua.cu_id "
					+ "and cus.cu_id=acc.cu_id "
					+ "and acc.ac_id =trn.tr_ac_id "
					+ "and tr_cu_id=?"
					+ "order by pay_date asc";
					  
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, cus_id);
			 listData = query.list();   
			tran.commit();
		}catch(HibernateException hne){
			if(tran!=null) tran.rollback();
			hne.printStackTrace();
			return null;
		}
		return listData;
	}

	
	
	
	// select transaction info
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<TransectionDto> Customer_Report(int cus_id) {
		//factory = new Configuration().configure().buildSessionFactory(); 
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		
		List listData =null;
		
		try{
			tran=session.beginTransaction(); 
			
		String sql = "select  "
				+ "c.co_id,"
				+ " c.co_first_nm,"
				+ " c.co_last_nm,"
				+ " c.co_sex, "
				+ " c.co_brand,"
				+ " c.co_national_id,"
				+ " c.co_phone,"
				+ " c.co_cpm_phone,"
				+ " cus.cu_id,"
				+ " cus.cu_nm,"
				+ " cus.cu_phone,"
				+ " cus.cu_dtt,"
				+ " cus.cu_address,"
				+ " acc.ac_amount,"
				+ " acc.ac_rate,"
				+ " acc.ac_start_date,"
				+ " acc.ac_end_date,"
				+ " acc.ac_period_type,"
				+ " acc.ac_period,"
				+ " gua.gu_id,"
				+ " gua.gu_nm,"
				+ " gua.gu_sex,"
				+ " gua.gu_phone,"
				+ " gua.gu_address" 
				
				+ " from "
					+ " mfi_co c,"
					+ " mfi_customers cus," 
					+ " mfi_account acc,"
					+ " mfi_guarantor gua "
				
			    + "where 1=1"
				
				+ "and c.co_id=cus.co_id "
				+ "and cus.cu_id=gua.cu_id "
				+ "and cus.cu_id=acc.cu_id " 
				+ "and cus.cu_id=?"; 
				  
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, cus_id);
			listData = query.list();  
			
			tran.commit();
		}catch(HibernateException hne){
			if(tran!=null) tran.rollback();
			hne.printStackTrace();
			return null;
		}
		return listData;
	}
	
		public void check_late() {
			Session session = factory.getCurrentSession();
			Transaction tran = null;				
			try{
				tran=session.beginTransaction(); 
				String sql = "UPDATE mfi_transection tr  SET  tr_stts='3' FROM mfi_customers cu,mfi_account ac  WHERE 1=1 "
							    +" and (cu.cu_id=ac.cu_id and  ac.ac_id=tr.tr_ac_id and  tr_stts='1' and  cu.cu_del_yn='Y')"			 
							    +" and ( "
									   +" (to_date(pay_date, 'YYYYMMDD24H') - CURRENT_DATE > 3 and ac_period_type='Day') "
									   +" or ( to_date(pay_date, 'YYYYMMDD24H')  - CURRENT_DATE > 7 and ac_period_type='Week') "
									   +" or (  to_date(pay_date, 'YYYYMMDD24H') - CURRENT_DATE > DATE_PART('days', DATE_TRUNC('month', NOW()) +'1 MONTH' - DATE_TRUNC('month', NOW())) and ac_period_type='Month')" 
							    +")";	  
				String sql1="UPDATE mfi_transection SET tr_stts='3' WHERE ( CURRENT_DATE - to_date(pay_date, 'YYYYMMDD24H') >= 1)";
				SQLQuery query = session.createSQLQuery(sql1);
				query.executeUpdate();
				tran.commit();
			}catch(HibernateException hne){
				if(tran!=null) tran.rollback();
				hne.printStackTrace();
			}	
		}
}
