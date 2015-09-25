package com.system.loan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.LoanAgreementDao;
import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoDto;

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreementController {
	LoanAgreementDao loanAgrDao=null;
		
	@RequestMapping(value="/newLoanAgreement", method = RequestMethod.POST)
	public String newLoanAgreement(AcountInfoDto acodto, LoanAgreementDao loanAgreDto, GuarantorInfoDto guDto){ 
		loanAgrDao = new LoanAgreementDao();
		loanAgrDao.InsertNewCustomer(acodto, loanAgreDto, guDto);
		
		return "loan_agreement";
	}
@RequestMapping(value="/loanlayout")	
public String loanlayout(){
	return "loan_agreement";
}
}


