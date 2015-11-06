package com.system.loan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.GuarantorInfoDto;
@Service
public class GuarantorDaoImp implements GuarantorDao {
	public static SessionFactory factory = null;
	public GuarantorDaoImp() {
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
	@SuppressWarnings("unchecked")
	@Override
	public List<GuarantorInfoDto> foundGuarantorByID(String cuID,String guID) {
		Session session = factory.getCurrentSession();
		List<GuarantorInfoDto>guarantor=null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Query query=session.createQuery("Select G From GuarantorInfoDto G WHERE cast(G.customerDto.cuID as string) Like ? And cast(G.gu_id as string) Like ? ");
		    query.setString(0, "%"+cuID+"%");
		    query.setString(1, "%"+guID+"%");
			guarantor=query.list();
			tx.commit();
		} catch (HibernateException e) {		
			e.printStackTrace();
			return null;
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
