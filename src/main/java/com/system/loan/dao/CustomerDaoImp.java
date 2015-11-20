package com.system.loan.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.pagingDto;

@Service
public class CustomerDaoImp implements CustomerDao {
	public static SessionFactory factory = null;

	public CustomerDaoImp() {
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

	/**
	 * Update Customer Information if true return true else return false
	 */
	@Override

	public Boolean updateCustomer(CustomerDto cus1) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, cus1.getCuID());
			cus.setCustomerUpdate(cus1.getCuName(), cus1.getCuNickName(), cus1.getCuSex(), cus1.getCuDOB(),
					cus1.getCuNationalID(), cus1.getCuPhone(), cus1.getCuAddress(), cus1.getCuPawn(), cus1.getCuNote(),
					cus1.getCuPhoto());

			for (GuarantorInfoDto gu : cus1.getGuarantorInfoDto()) {
				if (gu.getGu_id() != 0) {
					GuarantorInfoDto gu1 = (GuarantorInfoDto) session.get(GuarantorInfoDto.class, gu.getGu_id());
					gu1.setGuarantorUpdate(gu.getGu_nm(), gu.getGu_nick_nm(), gu.getGu_sex(), gu.getGu_national_id(),
							gu.getGu_dob(), gu.getGu_phone(), gu.getGu_address(), gu.getGu_pawn(), gu.getGu_note(),
							gu.getPhoto());
				}
			}

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Add Customer Information if true return true else return false
	 */
	@Override

	public Boolean insertCustomer(CustomerDto Customer) {
		Session session = factory.getCurrentSession();
		try {
			session.save(Customer);
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Delete Customer Information if true return true else return false
	 */
	@Override
	public Boolean deleteCustomer(CustomerDto customer) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CustomerDto cus = (CustomerDto) session.get(CustomerDto.class, customer.getCuID());
			cus.setCuDelYn(customer.getCuDelYn());
			session.update(cus);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		return true;
	}

	/**
	 * List Customer Information if true return List else return null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerDto> listCustomer(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		List<CustomerDto> list = null;
		String filter = "";
		String orderRec = " Order By cus.cu_id DESC";
		Transaction tx = null;
		try {
			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(cus.cu_id as string) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_nm) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_phone) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_address) like '%" + paging.getSw().toLowerCase()
							+ "%' ";
				}
			}
			tx = session.beginTransaction();
			String sql="select cus.cu_id,cus.cu_nm,cus.cu_sex,cus.cu_phone,cus.cu_national_id,cus.cu_address,loa.tr_id,loa.tr_type from mfi_customers cus ,mfi_loanapproval loa where 1=1 and cus.cu_id=loa.cu_id and cus.cu_del_yn='Y' and cast(cus.co_id as text) like ? " + filter +" "+ orderRec+"";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			/*Query query = session.createQuery(
					"select cus.cu_id,cus.cu_nm,cus.cu_sex, cus.cu_phone,cus.cu_national_id,cus.cu_address,loa.tr_id,loa.tr_typefrom mfi_customers cus ,mfi_loanapproval loawhere 1=1 and cus.cu_id=loa.cu_idand cast(cus.co_id as text) like ?"
							// .createQuery("From CustomerDto C where 1=1 And
							// C.cuDelYn='Y' And cast(C.customerOfficerDto.coID
							// as text) Like ? "
							+ filter + orderRec);*/
			query.setString(0, "%" + coID + "%");
			query.setFirstResult((paging.getPageNo() - 1) * paging.getPcnt());
			query.setMaxResults(paging.getPcnt());
			list = (List<CustomerDto>) query.list();

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public int totalCus(pagingDto paging, String coID) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		int cnt = 0;
		String filter = "";
		Transaction tx = null;
		try {

			if (paging.getSw() != null) {
				if (paging.getSw() != "") {
					filter = " and  cast(cus.cu_id as string) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_nm) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_phone) like '%" + paging.getSw().toLowerCase()
							+ "%' Or lower(cus.cu_address) like '%" + paging.getSw().toLowerCase()
							+ "%' ";
				}
			}
			tx = session.beginTransaction();
			String sql="select  count(*) as cnt from mfi_customers cus ,mfi_loanapproval loa where 1=1 and cus.cu_id=loa.cu_id and cast(cus.co_id  as text) like ?  " + filter +"";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			/*Query query = session.createQuery(
					"Select Count(C.cuID) From CustomerDto C where 1=1 and C.cuDelYn='Y' And cast(C.customerOfficerDto.coID as text) like ?  "
							+ filter);*/

			query.setString(0, "%" + coID + "%");
			HashMap<String,Object> result=(HashMap<String, Object>)query.uniqueResult();
			cnt=Integer.parseInt(result.get("cnt").toString());
			
			/*List<Object> list = (List<Object>) query.list();
			for (Object ob : list) {
				cnt = Integer.parseInt(ob.toString());
			}*/
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return cnt;
	}

	/**
	 * List Customer by id if true return List else return null
	 */

	public CustomerDto listSpecificCustomer(String cuID) {
		Session session = factory.getCurrentSession();
		CustomerDto cus = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			cus = (CustomerDto) session.get(CustomerDto.class, Integer.parseInt(cuID));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return cus;
	}

	public long getTotalCustomer() {
		Session session = factory.getCurrentSession();
		long cnt = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("Select Count(*) From CustomerDto c Where c.cuDelYn='Y'");
			cnt = (long) query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			System.out.println(" error total remord");
			e.printStackTrace();
		}
		return cnt;
	}

}
