package com.system.loan.dao;

import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.LoanAgreementDto;
import com.system.loan.dto.TransectionDto;

public interface LoanAgreement {
	public boolean InsertNewCustomer(LoanAgreementDto loanAgreDto);
	//public boolean InsertTransection(TransectionDto tranDto);
}
