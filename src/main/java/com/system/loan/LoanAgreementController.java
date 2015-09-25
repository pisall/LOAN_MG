package com.system.loan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.loan.dao.LoanAgreementDao;
import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoDto;

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreementController {

		LoanAgreementDao loanAgreDao = null;
		@RequestMapping(value="/newLoanAgreement")
		public String newLoanAgreement(AcountInfoDto acodto, LoanAgreementDao loanAgreDto, GuarantorInfoDto guDto){
			loanAgreDao = new LoanAgreementDao();
			loanAgreDao.InsertNewCustomer(acodto, loanAgreDto, guDto);
			return "loan_agreement";
		}
		
	 
		/*@RequestMapping(value="/schedulepay")
		public String SchedulePayment(){
			return "customer";
		}
		@RequestMapping(value="/send_email")
		public String customerOfficer(){
			return "send_email";
		}
		@RequestMapping(value="/mail")
		public String loanIncome(){
			return "mail";
		}*/
		 
}
