package com.system.loan.dao.report;

import java.math.BigDecimal;
import java.util.HashMap;
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

import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

@Service
public class ReportDaoImp implements ReportDao {
	public static SessionFactory factory = null;

	public ReportDaoImp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures																								// hibernate.cfg.xml
				.build();
		try {
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcountInfoDto> listExpendreport(pagingDto paging, String coID) {
		Session session = factory.getCurrentSession();
		List<AcountInfoDto> list = null;	
		Transaction tx = null;	
		try {
			tx = session.beginTransaction();
			String sql="select "
							+"cus.cu_id, "
							+"cus.cu_nm, "
							+"co.co_first_nm, "
							+"co.co_last_nm, "
							+"co.co_id,ac_start_date, "
							+"ac.ac_amount " 
							+"from mfi_customers cus , mfi_account ac,mfi_co co "   
							+"where 1=1  "
								+"and (cus.cu_id=ac.cu_id) "    							
								+"and (ac.ac_stat='Y') "       
					            +"and (cus.cu_del_yn='Y') "       
					            +"and ( cast(cus.co_id as TEXT) LIKE ? ) " + getFilter(paging) + " Order By ac.ac_start_date DESC ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setString(0, "%" + coID + "%");
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list = (List<AcountInfoDto>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public int totalExpendReport(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int cnt = 0;	
		Transaction tx = null;	
		try {		
			tx = session.beginTransaction();
			String sql="SELECT count(*) cnt FROM( "
							+"select "
							+"cus.cu_id, "
							        +"cus.cu_nm, "
							        +"co.co_first_nm, "
							        +"co.co_last_nm, "
							        +"co.co_id, "
							        +"ac_start_date, "
							        +"ac.ac_amount " 
							    +"from "
							        +"mfi_customers cus, "
							        +"mfi_account ac, "
							        +"mfi_co co " 
							    +"where "
							        +"1=1 "   
							        +"and ( "
							            +"cus.cu_id=ac.cu_id "
							        +") "
							        +"and ( "
							            +"ac.ac_stat='Y' "
							        +") "
							        +"and ( "
							            +"cus.cu_del_yn='Y' "
							        +") "
							        +"and ( "
							            +"cast(cus.co_id as TEXT) LIKE ? "
							        +") "  
							        +" " + getFilter(paging) + " "
							    +"Order By "
							        +"ac.ac_start_date DESC "
					   +") cnt ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);			
			query.setString(0, "%" + coID + "%");
			HashMap<String,Object> result=(HashMap<String, Object>)query.uniqueResult();		
			cnt=Integer.parseInt(result.get("cnt").toString());		
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public Object getTotalIncomeOutcome(String coID,pagingDto paging) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = null;	
		Object result=null;
		try {		
			tx = session.beginTransaction();
			String sql="select "     
					       +"cast(SUM (ac_amount) as DECIMAL) AS total_amount, "   
					       +"cast(SUM (loa.paid_amount) as DECIMAL) AS total_paid_amount, "     
					       +"cast(SUM (loa.amount_fine) as DECIMAL) AS total_amount_fine "      
					       +"from mfi_customers cus , mfi_account ac,mfi_co co ,mfi_loanapproval loa ,mfi_transection tr " 
					       +"where 1=1  "    
									+"and (cus.cu_id=ac.cu_id)  " 
									+"and (ac.ac_id=tr.tr_ac_id) "  						
									+"and (tr.tr_id=loa.tr_id) "
					        +"and (ac.ac_stat='Y') "     
					        +"and (cus.cu_del_yn='Y') "     
					        +"and ( cast(cus.co_id as TEXT) LIKE ? ) "+ getFilter(paging)+ " ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
			query.setString(0, "%" + coID + "%");
			result=query.uniqueResult();	
		
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return result;
	}

	
	public String getFilter(pagingDto paging){
		String filter="";
		if ( paging.getStartDate()!=null || paging.getEndDate()!=null ) {
		if ( paging.getStartDate() !="" || paging.getEndDate()!="") {	
			if(paging.getStartDate() !="" &&  paging.getEndDate()!=""){
				filter=" and(to_char(to_date(ac_start_date, 'YYYYMMDDHH24MISS'),'YYYY-MM-DD') BETWEEN '"+paging.getStartDate()+"'  AND '"+paging.getEndDate()+"' )";
			}	 
		}
		}
		return filter;
	}
	
	public List listReportLate(pagingDto paging, String coID) {
		Session session = factory.getCurrentSession();
		List result = null;	
		Transaction tx = null;	
		try {
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(getSqlLoanLate());
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setString(0, "%" + coID + "%");
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			result = query.list();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}//
		return result;
	}
	
    public String getSqlLoanLate(){
    	String sql="";
    					sql="SELECT "
    					    +"co_first_nm "
    					    +",co_last_nm "
    					    +",co_phone "
							+",ac.ac_id "
							+",cu.cu_nm " 
							+",cu.cu_id "
							+",sum(tr_pay_amount) paid_amount  "
							+",sum(tr_origin_amount) loan_amount "
							  +",to_date((select tr2.pay_date "
										+"from mfi_transection tr2 "
											+"where tr2.tr_stts='3' and tr2.tr_ac_id=tr.tr_ac_id " 
												+"order by tr2.pay_date DESC limit 1 "
							   +"),'YYYYMMDD24H') payment_date "
								+",(select (CURRENT_DATE - to_date(tr2.pay_date, 'YYYYMMDD24H')) "
										+"from mfi_transection tr2 "
											+"where tr2.tr_stts='3' and tr2.tr_ac_id=tr.tr_ac_id " 
												+"order by tr2.pay_date ASC limit 1 "
							   +") days_late "
								+",(SELECT "
										+"CASE  "
											+"WHEN  (CURRENT_DATE - (to_date(tr2.pay_date,'YYYYMMDD24H'))) > 3 AND (ac.ac_period_type='Day' OR ac.ac_period_type='Week') "  
											+"THEN  (CURRENT_DATE - (to_date(tr2.pay_date,'YYYYMMDD24H'))) - 3 ELSE 0 "  
										+"END total_days_weeks_late "   
							   +"FROM "  
										 +"mfi_transection tr2  "
								 +"WHERE "  
										 +"tr2.tr_ac_id=tr.tr_ac_id  "  	    
								 +"AND "  
										 +"tr2.tr_stts='3' order by tr2.pay_date ASC limit 1 " 
							  +") "
								+",(SELECT "
										+"CASE WHEN (CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) > 3  AND (ac_period_type='Day' OR ac_period_type='Week') "  
												 +"THEN (tr_pay_amount * 0.1 * ((CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) - 3)) ELSE 0  " 
										+"END amount_fine_days_weeks_late  " 
										+"FROM  "
												+"mfi_transection tr2 " 
										+"WHERE "  
												+"tr2.tr_ac_id=tr.tr_ac_id "   	    
										+"AND  " 
												+"tr2.tr_stts='3' order by tr2.pay_date ASC limit 1 " 
							  +") "
							  +",(SELECT "  
										+"CASE WHEN (CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) > 1 AND ac_period_type='Month' "  
												 +"THEN (CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) - 1 ELSE 0 "  
										+"END total_months_late "  
								+"FROM "  
												+"mfi_transection tr2 "
								+"WHERE "  
												+"tr2.tr_ac_id=tr.tr_ac_id "   	    
										+"AND "  
												+"tr2.tr_stts='3' order by tr2.pay_date ASC limit 1 " 
							 +")"
							 +",(SELECT "
								+"CASE WHEN (CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) > 1  AND ac_period_type='Month' " 
										 +"THEN (tr_pay_amount * 0.1 * ((CURRENT_DATE - (to_date(pay_date,'YYYYMMDD24H'))) - 1)) ELSE 0  " 
										 +"END amount_fine_months_late "
								+"FROM "  
											+"mfi_transection tr2 " 
								+"WHERE "  
											+"tr2.tr_ac_id=tr.tr_ac_id  "  	    
										 +"AND "  
											+"tr2.tr_stts='3' order by tr2.pay_date ASC limit 1 " 
							  +") "
								+"from "
									+"mfi_customers cu, mfi_account ac ,  mfi_transection tr ,mfi_co co "
								+"WHERE cu.co_id=co.co_id and  cu.cu_id=ac.cu_id and  ac.ac_id=tr.tr_ac_id "
								+"and tr.tr_stts='3' and cu.cu_del_yn='Y' and  CAST(co.co_id AS TEXT) LIKE ? "
								+"group by co_phone,co_first_nm  ,co_last_nm , ac.ac_id,cu.cu_nm,cu.cu_id,payment_date,days_late,total_days_weeks_late,amount_fine_days_weeks_late,amount_fine_days_weeks_late,total_months_late,amount_fine_months_late ORDER BY payment_date DESC";
    			return sql;		
    }
	
	@SuppressWarnings("unchecked")
	public int getTotalLoanLate(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int cnt = 0;	
		Transaction tx = null;	
		try {		
			tx = session.beginTransaction();
			String sql="select count(*) cnt from("+getSqlLoanLate()+") cnt";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);			
			query.setString(0, "%" + coID + "%");
			HashMap<String,Object> result=(HashMap<String, Object>)query.uniqueResult();
			cnt=Integer.parseInt(result.get("cnt").toString());		
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return cnt;
	}	
	
	
}
