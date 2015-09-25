package com.system.loan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreement {

		@RequestMapping(value="/newLoanAgreement")
	public String newLoanAgreement(){
		return "loan_agreement";
	}
	
		
		@RequestMapping(value="/schedulepay")
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
		}
		 
}
