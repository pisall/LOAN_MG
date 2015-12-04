package com.system.loan.dao.co;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.stereotype.Service;

import com.system.loan.dto.pagingDto;
import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.co.in.co_0001_in;
import com.system.loan.dto.session.USER_SESSION;
@Service
public class CO_DAO_001_IMP implements CO_DAO_001{
	private SessionFactory factory=null;
	
	public CO_DAO_001_IMP(){
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
	public HashMap<String, Object> newCoLog(CO_DTO_001 CO,LOGIN_DTO_001 LOG,int REG_CO_ID) {//test
		// TODO Auto-generated method stub
		
		HashMap<String, Object> result=new HashMap<>();
		result.put("ERROR", false);
		result.put("MESSAGE", "");
		
		
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try {
			int count=countByLogId(LOG.getLog_email());
			if(count>0){
				result.put("ERROR", true);
				result.put("MESSAGE", "duplicated record");
				return result;
			}
			CO_DTO_001 reg_co=findCoById(REG_CO_ID);
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			tx.setTimeout(5);
			//CO.setLoginDTO(LOG);
			CO.setRegCo(reg_co);
			LOG.setCoDTO(CO);
			session.save(CO);
			session.save(LOG);
//			
			tx.commit();
			
			return result;
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
		
	}
	@SuppressWarnings("unused")
	@Override
	public int countByLogId(String LogEmail) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(*) from LOGIN_DTO_001 where log_email=?");
			query.setString(0, LogEmail);
			Object count=query.uniqueResult();
			int intc=Integer.parseInt(count.toString());
			tx.commit();
			return intc;
			
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	@Override
	public CO_DTO_001 findCoById(int id) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		 try{
			 tx=session.beginTransaction();
			   CO_DTO_001 co_001 =(CO_DTO_001) session.get(CO_DTO_001.class, id);
			  tx.commit();
			  return co_001;
		 }catch(Exception ex){
			   ex.printStackTrace();
		 }
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List coList(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			String[] listSw;
			String filter="";
			if(paging.getSw()!=null){
				if(paging.getSw().length()>0){
					listSw=paging.getSw().split(" ");
					
					if(listSw.length>0){
						filter=" and(";
						for(int i=0;i<listSw.length;i++){
							if(i>0){
								filter+=" or ";
							}
							filter+="co_first_nm like '%"+listSw[i]+"%' or co_last_nm like '%"+listSw[i]+"%' or cast(co_id as text) like '%"+listSw[i]+"%'";
						}
						filter+=")";
					}
				}
				
			}
			
			Query query=session.createQuery("select new map(co_id as co_id,"
					+ "co_first_nm as co_first_nm,"
					+ "co_last_nm as co_last_nm,"
					+ "co_sex as co_sex,"
					+ "co_brand as co_brand,"
					+ "co_phone as co_phone,"
					+ "other_edit_prof as other_edit_prof,"
					+ "regCo.co_id as reg_co_id,"
					+ "regCo.co_first_nm as reg_co_first_nm,"
					+ "regCo.co_last_nm as reg_co_last_nm) from CO_DTO_001 where loginDTO.enabled=true  "+filter+" order by co_id");
			
			/*Query query=session.createQuery("from CO_DTO_001 where loginDTO.enabled=true");*/
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			
			List result=(List)query.list();
			tx.commit();
			return result;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HashMap<String, Object> findCoById2(int id) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			//Query query=session.createQuery("select new map(co_id as co_id) from CO_DTO_001");
			Query query=session.createQuery("select new map("
					+ "co_id as co_id,"
					+ "co_first_nm as co_first_nm,"
					+ "co_last_nm as co_last_nm,"
					+ "co_sex as co_sex,"
					+ "co_brand as co_brand,"
					+ "co_phone as co_phone,"
					+ "co_cpm_phone as co_cpm_phone,"
					+ "dob as dob,"
					+ "address as address,"
					+ "co_pb_address as co_pb_address,"
					+ "co_national_id as co_national_id,"
					+ "reg_dtt as reg_dtt,"
					+ "update_dtt as update_dtt,"
					+ "regCo.co_id as reg_co_id,"
					+ "regCo.co_first_nm as reg_co_first_nm,"
					+ "regCo.co_last_nm as reg_co_last_nm,"
					+ "loginDTO.log_email as log_email,"
					+ "loginDTO.log_type as log_type) from CO_DTO_001 where co_id=?");
			query.setInteger(0, id);
			
			HashMap<String, Object> result=new HashMap();
			List list=query.list();
			if(list.size()>0){
				result=(HashMap<String, Object>)list.get(0);
			}
			tx.commit();
			return result;
		}catch(HibernateException e){
			e.printStackTrace();
			
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public HashMap<String, Object> findLogByLogMail(String email) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(log_email as log_email,log_password as log_password,log_type as log_type,enabled as enabled) from LOGIN_DTO_001 where log_email=?");
			query.setString(0, email);
			List list=query.list();
			tx.commit();
			HashMap<String, Object> result=new HashMap<>();
			if(list.size()>0){
				 result=(HashMap<String, Object>) list.get(0);
			}
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String, Object> findCobyUserId(String userid){
		Session session=null;
		Transaction tx=null;
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(co_id as co_id,co_first_nm as co_first_nm,co_last_nm as co_last_nm,other_edit_prof as other_edit_prof) from CO_DTO_001 where loginDTO.log_email=?");
			query.setString(0, userid);
			List list=(List)query.list();
			tx.commit();
			HashMap<String, Object> user=new HashMap<>();
			if(list.size()>0){
				user=(HashMap<String, Object>) list.get(0);
				return user;
			}else{
				return null;
			}
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public HashMap<String, Object> updateEnabledUser(List<Integer> id, boolean enabled) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		try{
			
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
//			CO_DTO_001 co=(CO_DTO_001)session.get(CO_DTO_001.class, id);
//			co.getLoginDTO().setEnabled(enabled);
//			session.update(co);
			
			String sql="update mfi_login set enabled=? where co_id=?";
			Query query=session.createSQLQuery(sql);
			query.setBoolean(0, enabled);
			for(int item:id){
				query.setInteger(1, item);
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				int count=query.executeUpdate();
			}
			

			tx.commit();
			result.put("ERROR", false);
			return result;
			
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
		result.put("ERROR", true);
		return null;
	}
	
	/*public HashMap<String, Object> updateCo(co_0001_in input){
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		try{
			result.put("ERROR", true);
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			CO_DTO_001 co=(CO_DTO_001)session.get(CO_DTO_001.class, input.getCo_id());
			co.setCo_first_nm(input.getCo_first_nm());
			co.setCo_last_nm(input.getCo_last_nm());
			co.setCo_sex(input.getCo_sex());
			co.setDob(input.getDob());
			co.setCo_national_id(input.getCo_national_id());
			co.setAddress(input.getAddress());
			co.setCo_pb_address(input.getCo_pb_address());
			co.setCo_phone(input.getCo_phone());
			co.setCo_cpm_phone(input.getCo_cpm_phone());
			co.setCo_brand(input.getCo_brand());
			session.update(co);
			tx.commit();
			result.put("ERROR", false);
			return result;
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return result;
	}*/
	
	public HashMap<String, Object> updateCo(co_0001_in input,HttpServletRequest req){
		HttpSession sess=req.getSession();
		USER_SESSION user=(USER_SESSION)sess.getAttribute("USER_SESSION");
		int sesCoId=user.getCoId();
		
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		try{
			result.put("ERROR", true);
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			CO_DTO_001 co=(CO_DTO_001)session.get(CO_DTO_001.class, input.getCo_id());
			int coId=co.getCo_id();
			if(coId!=sesCoId){
				if(!co.isOther_edit_prof()){
					tx.rollback();
					result.put("ERROR", true);
					result.put("MESSAGE", "authortication is required.");
					
				}
			}
			co.setCo_first_nm(input.getCo_first_nm());
			co.setCo_last_nm(input.getCo_last_nm());
			co.setCo_sex(input.getCo_sex());
			co.setDob(input.getDob());
			co.setCo_national_id(input.getCo_national_id());
			co.setAddress(input.getAddress());
			co.setCo_pb_address(input.getCo_pb_address());
			co.setCo_phone(input.getCo_phone());
			co.setCo_cpm_phone(input.getCo_cpm_phone());
			co.setCo_brand(input.getCo_brand());
			session.update(co);
			tx.commit();
			result.put("ERROR", false);
			return result;
		
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public HashMap<String, Object> updateProfile(co_0001_in input){
		Session session=null;
		Transaction tx=null;
		HashMap<String, Object> result=new HashMap<>();
		try{
			result.put("ERROR", true);
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			CO_DTO_001 co=(CO_DTO_001)session.get(CO_DTO_001.class, input.getCo_id());
//			co.setCo_first_nm(input.getCo_first_nm());
//			co.setCo_last_nm(input.getCo_last_nm());
//			co.setCo_sex(input.getCo_sex());
			co.setDob(input.getDob());
			co.setCo_national_id(input.getCo_national_id());
			co.setAddress(input.getAddress());
			co.setCo_pb_address(input.getCo_pb_address());
			co.setCo_phone(input.getCo_phone());
			co.setCo_cpm_phone(input.getCo_cpm_phone());
			co.setCo_brand(input.getCo_brand());
			co.setUpdate_dtt(input.getUpdate_dtt());
			session.update(co);
			tx.commit();
			result.put("ERROR", false);
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		result.put("ERROR", true);
		return null;
	}
	
	@Override
	public pagingDto getPaging(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try{
			String[] listSw;
			String filter="";
			if(paging.getSw()!=null){
				if(paging.getSw().length()>0){
					listSw=paging.getSw().split(" ");
					
					if(listSw.length>0){
						filter=" and(";
						for(int i=0;i<listSw.length;i++){
							if(i>0){
								filter+=" or ";
							}
							filter+="co_first_nm like '%"+listSw[i]+"%' or co_last_nm like '%"+listSw[i]+"%' or cast(co_id as text) like '%"+listSw[i]+"%'";
						}
						filter+=")";
					}
				}
				
			}
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(*) as pcnt from CO_DTO_001 where loginDTO.enabled=true"+ filter);
			int pcount=Integer.parseInt(query.uniqueResult().toString());//(int)query.uniqueResult().toString();
			System.out.println("pcoutn="+pcount);
			if(paging.getPageNo()<1){
				paging.setPageNo(1);
			}
			if(pcount>0){
				int totalPage=(int) Math.ceil((float) pcount/paging.getPcnt());
				if(totalPage<paging.getPageNo()){
					paging.setPageNo(totalPage);
				}
				
				paging.setTotal(pcount);
				paging.setTotalPage(totalPage);
				
			}else{
				paging.setPageNo(1);
				paging.setTotal(0);
				paging.setTotalPage(0);
			}
			
			tx.commit();
			return paging;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return paging;
	}
	
	
	public HashMap<String, Object> getCoLeftJoinLogById(int id){
		
		Session session=null;
		Transaction tx=null;
		try{
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createSQLQuery("select co_id,"
					+ "co_first_nm,"
					+ "co_last_nm,"
					+ "co_sex,"
					+ "co_brand,"
					+ "co_phone,"
					+ "co_cpm_phone,"
					+ "address "
					+ " from mfi_co where co_id=?");
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.setInteger(0, id);
			
			HashMap<String, Object> result=(HashMap<String, Object>)query.uniqueResult();
			
			tx.commit();
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	//get privacy
	
	public HashMap<String, Object> getPrivacy(HttpServletRequest req){
		
		HttpSession sess=req.getSession();
		USER_SESSION user=(USER_SESSION)sess.getAttribute("USER_SESSION");
		int coId=0;
		
		HashMap<String, Object> result=new HashMap<>();
		
		Session session=null;
		Transaction tx=null;
		try{
			if(user==null){
				result.put("ERROR", true);
				result.put("MESSAGE", "Access denied");
				return result;
			}else{
				coId=user.getCoId();
			}
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select new map(other_edit_prof as other_edit_prof) from CO_DTO_001 where co_id=?");
			query.setParameter(0, coId);
			List list=(List)query.list();
			
			tx.commit();
			
			if(list.size()>0){
				HashMap<String, Object> privacyHash=(HashMap<String, Object>)list.get(0);
				String strIsOtherEditProf=privacyHash.get("other_edit_prof").toString();
				if(strIsOtherEditProf!=null){
					if(strIsOtherEditProf.length()>0){
						if(strIsOtherEditProf.equals("true") || strIsOtherEditProf.equals("1")||strIsOtherEditProf.equals("TRUE")){
							result.put("other_edit_prof", true);
						}else{
							result.put("other_edit_prof", false);
						}
					}else{
						result.put("other_edit_prof", false);
					}
					
				}else{
					result.put("other_edit_prof", false);
				}
				
			}else{
				result.put("ERROR", true);
				result.put("MESSAGE", "Please login.");
				return result;
			}
			result.put("ERROR", false);
			return result;
			
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public HashMap<String, Object> changeIsOtherEditProf(boolean isOtherEditProf,HttpServletRequest req){
		HttpSession sess=req.getSession();
		USER_SESSION user=(USER_SESSION)sess.getAttribute("USER_SESSION");
		int coId=0;
		
		HashMap<String, Object> result=new HashMap<>();
		
		Session session=null;
		Transaction tx=null;
		
		try{
			if(user==null){
				result.put("ERROR", true);
				result.put("MESSAGE", "Access denied");
				return result;
			}else{
				coId=user.getCoId();
			}
			CO_DTO_001 co=findCoById(coId);
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			co.setOther_edit_prof(isOtherEditProf);
			session.update(co);
			tx.commit();
			
			result.put("ERROR", false);
			return result;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	//list of trush co
	public List coTrushList(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			String[] listSw;
			String filter="";
			if(paging.getSw()!=null){
				if(paging.getSw().length()>0){
					listSw=paging.getSw().split(" ");
					
					if(listSw.length>0){
						filter=" and(";
						for(int i=0;i<listSw.length;i++){
							if(i>0){
								filter+=" or ";
							}
							filter+="co_first_nm like '%"+listSw[i]+"%' or co_last_nm like '%"+listSw[i]+"%' or cast(co_id as text) like '%"+listSw[i]+"%'";
						}
						filter+=")";
					}
				}
				
			}
			
			Query query=session.createQuery("select new map(co_id as co_id,"
					+ "co_first_nm as co_first_nm,"
					+ "co_last_nm as co_last_nm,"
					+ "co_sex as co_sex,"
					+ "co_brand as co_brand,"
					+ "co_phone as co_phone,"
					+ "regCo.co_id as reg_co_id,"
					+ "regCo.co_first_nm as reg_co_first_nm,"
					+ "regCo.co_last_nm as reg_co_last_nm) from CO_DTO_001 where loginDTO.enabled=false"+ filter);
			
			/*Query query=session.createQuery("from CO_DTO_001 where loginDTO.enabled=true");*/
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			
			List result=(List)query.list();
			tx.commit();
			return result;
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return null;
	}
	//paging co list trush
	
	public pagingDto getPangingTrush(pagingDto paging) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		try{
			String[] listSw;
			String filter="";
			if(paging.getSw()!=null){
				if(paging.getSw().length()>0){
					listSw=paging.getSw().split(" ");
					
					if(listSw.length>0){
						filter=" and(";
						for(int i=0;i<listSw.length;i++){
							if(i>0){
								filter+=" or ";
							}
							filter+="co_first_nm like '%"+listSw[i]+"%' or co_last_nm like '%"+listSw[i]+"%' or cast(co_id as text) like '%"+listSw[i]+"%'";
						}
						filter+=")";
					}
				}
				
			}
			session=factory.getCurrentSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(*) as pcnt from CO_DTO_001 where loginDTO.enabled=false"+ filter);
			int pcount=Integer.parseInt(query.uniqueResult().toString());//(int)query.uniqueResult().toString();
			if(paging.getPageNo()<1){
				paging.setPageNo(1);
			}
			if(pcount>0){
				int totalPage=(int) Math.ceil((float) pcount/paging.getPcnt());
				if(totalPage<paging.getPageNo()){
					paging.setPageNo(totalPage);
				}
				
				paging.setTotal(pcount);
				paging.setTotalPage(totalPage);
				
			}else{
				paging.setPageNo(1);
				paging.setTotal(0);
				paging.setTotalPage(0);
			}
			
			tx.commit();
			return paging;
			
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
		return paging;
	}

}
