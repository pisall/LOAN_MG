package com.system.loan.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.CoDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.LoanAgreementDto;

public class LoanAgreementDao {
	public static SessionFactory factory = null;

	public LoanAgreementDao() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println(e.toString());
			e.printStackTrace();
			if (e.getCause() != null) {
				System.out.println(e.getCause().getMessage());
			}
		}
	}

	// insert new Loan Agreement info
	public boolean InsertNewCustomer(AcountInfoDto acodto, LoanAgreementDto loanAgreDto, GuarantorInfoDto guDto)
			throws IllegalStateException {
		Session session = factory.openSession();
		Transaction transection = null;
		Integer co_id = null;
		CoDto codto = null;
		try {
			transection = session.beginTransaction();
			codto = (CoDto) session.get(CoDto.class, 1);
			System.out.println("---------9999999CO_ID get form login--------- :=" + codto);
			loanAgreDto.setCoDto(codto);
			session.save(loanAgreDto);
			session.save(acodto);
			session.save(guDto);
			transection.commit();
		} catch (HibernateException e) {
			if (transection != null)
				transection.rollback();
			e.printStackTrace();
			return false;
		} finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return true;
	}

}
