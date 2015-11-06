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

import com.system.loan.dto.LoanApprovalDto;

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
	public boolean TranSac_Update(int tr_id, String tr_type) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		 
		try{
			tran=session.beginTransaction();
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String datetime = format.format(date); 
			
			String sql = "update mfi_transection "
						+ "set tr_stts=?"
						+ "where tr_id=?";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setParameter(0, tr_type);
			query.setParameter(1, tr_id);
			query.executeUpdate(); 
			tran.commit();
		}catch(HibernateException e){
			if(tran!=null) tran.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		return true;
	}

}
