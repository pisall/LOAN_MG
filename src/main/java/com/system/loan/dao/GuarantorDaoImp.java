package com.system.loan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.GuarantorInfoDto;
import org.springframework.transaction.annotation.Transactional;
@Service
@Repository
@Transactional
public class GuarantorDaoImp implements GuarantorDao {
	public static SessionFactory factory = null;
	public GuarantorDaoImp() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			if (e.getCause() != null)
				System.out.println(e.getCause().getMessage());
		}
	}
	@Override
	public List<GuarantorInfoDto> foundGuarantorByID(String cuID,String guID) {
		Session session = factory.openSession();
		List<GuarantorInfoDto>guarantor=null;
		try {
			Query query=session.createQuery("Select G From GuarantorInfoDto G WHERE cast(G.customerDto.cuID as string) Like ? And cast(G.gu_id as string) Like ? ");
		    query.setString(0, "%"+cuID+"%");
		    query.setString(1, "%"+guID+"%");
			guarantor=query.list();
		} catch (HibernateException e) {		
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return guarantor;
	}

	@Override
	public Boolean deleteGuarantor(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateGuarantor(GuarantorInfoDto guarantor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertGuarantor(GuarantorInfoDto guarantor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuarantorInfoDto> listGuarantor() {
		// TODO Auto-generated method stub
		return null;
	}

}
