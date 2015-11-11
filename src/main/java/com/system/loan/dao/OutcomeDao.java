package com.system.loan.dao;

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

public class OutcomeDao implements OutcomeInferface{
	public static SessionFactory factory = null;
	public OutcomeDao(){
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
	
	 
	public Object Outcome() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tran = null;
		List listOutcome =null;
		try{
		tran=session.beginTransaction();
		String sql  = "select "
					+ "ac_id,"
					+ "cu_id," 
					+ "(select  sum(ac_amount) as out1 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '0 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '1 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'0 month','Month') as mon1),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '1 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '2 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'1 month','Month') as mon2),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '2 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '3 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'2 month','Month') as mon3),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '3 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '4 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'3 month','Month') as mon4),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '4 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '5 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'4 month','Month') as mon5),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '5 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '6 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'5 month','Month') as mon6),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '6 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '7 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'6 month','Month') as mon7),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '7 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '7 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'7 month','Month') as mon8),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '8 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '8 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'8 month','Month') as mon9),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '9 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '10 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'9 month','Month') as mon10),"
					+ "(select  sum(ac_amount) as out2 from mfi_account where cast(ac_start_date as bigint) <= cast(to_char( (now()-interval '10 month'),'YYYYMMDDHHMISS') as bigint)  and  cast(ac_start_date as bigint)  >= cast(to_char( (now()-interval '11 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'10 month','Month') as mon11),"
					+ "(select  sum(paid_amount) as in2 from mfi_loanapproval where  cast(tr_dtt as bigint) <= cast(to_char( (now()-interval '11 month'),'YYYYMMDDHHMISS') as bigint) and  cast(tr_dtt as bigint)  >= cast(to_char( (now()-interval '12 month'),'YYYYMMDDHHMISS') as bigint)),"
					+ "(select to_char(CURRENT_DATE-INTERVAL'11 month','Month') as mon12)"
					+ "from mfi_account  "
					+ "where 1=1 limit 12";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); 
			listOutcome = query.list();  
			System.out.println("99999999999:"+listOutcome);
			tran.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		 
		return listOutcome;
	}

	 

}
