package com.system.loan.dao;

import javax.servlet.http.HttpServletRequest;

import com.system.loan.dto.LoanAgreementDto;

public interface LoanAgreement {
	public boolean InsertNewCustomer(LoanAgreementDto loanAgreDto, int co_id);
	//public boolean InsertTransection(TransectionDto tranDto);
}
