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
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
																									// settings
																									// from
																									// hibernate.cfg.xml
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
			String sql="select cus.cu_id,cus.cu_nm,co.co_first_nm,co.co_last_nm,co.co_id,ac_start_date,ac.ac_amount from mfi_customers cus , mfi_account ac,mfi_co co where 1=1 and (cus.cu_id=ac.cu_id) and (co.co_id=cus.co_id) and (ac.ac_stat='Y') and (cus.cu_del_yn='Y') and  (cast(cus.co_id as TEXT) LIKE ?) " + getFilter(paging) + " Order By ac.ac_start_date DESC";
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
	
	@SuppressWarnings("unchecked")
	public int totalExpendReport(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int cnt = 0;	
		Transaction tx = null;	
		try {		
			tx = session.beginTransaction();
			String sql="select count(*) as cnt from (select DISTINCT cus.cu_id from mfi_customers cus , mfi_account ac,mfi_co co  where 1=1 and (cus.cu_id=ac.cu_id) and (co.co_id=cus.co_id)and (ac.ac_stat='Y') and (cus.cu_del_yn='Y')and  cast(cus.co_id as TEXT) LIKE ?  " + getFilter(paging) +") as total";
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
	public BigDecimal getTotalAmount(String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		BigDecimal cnt = new BigDecimal(0.0);	
		Transaction tx = null;	
		try {		
			tx = session.beginTransaction();
			String sql="select cast(SUM (ac_amount) as DECIMAL) AS total_amount from mfi_customers cus , mfi_account ac,mfi_co co where 1=1 and (cus.cu_id=ac.cu_id) and (co.co_id=cus.co_id) and (ac.ac_stat='Y') and (cus.cu_del_yn='Y') and  (cast(cus.co_id as TEXT) LIKE ?) ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);	
			query.setString(0, "%" + coID + "%");
			HashMap<String,Object> result=(HashMap<String, Object>)query.uniqueResult();
			cnt=(BigDecimal) result.get("total_amount");	
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
					+"cast(SUM (loa.amount_fine) as DECIMAL) AS total_amount_fine  "
					+"from mfi_customers cus , mfi_account ac,mfi_co co ,mfi_loanapproval loa "
					+"where 1=1 and (cus.cu_id=ac.cu_id) "
					+ "and (co.co_id=cus.co_id) "
					+ "and (co.co_id=loa.co_id) "
					+ "and (ac.ac_stat='Y') "
					+ "and (cus.cu_del_yn='Y') "
					+ "and (cast(cus.co_id as TEXT) LIKE ? ) "+ getFilter(paging)+"";
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

}
