package com.system.loan;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.loan.dao.LoanAgreementDao;
import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.LoanAgreementDto;

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreementController {
		 
		//String username = request.getParameter("us_name"); 
		
		LoanAgreementDao loanAgreDao = null;
		@RequestMapping(value="/newLoanAgreement")
		public String newLoanAgreement(AcountInfoDto acodto,GuarantorInfoDto guinfoDto, LoanAgreementDto loanAgreDto){
			System.out.println("Customer Name:="+loanAgreDto.getCu_nm());
			System.out.println("Guarantor name:="+guinfoDto.getGu_full_nm());
			System.out.println("AMOUNT :="+acodto.getAmount());
			loanAgreDao = new LoanAgreementDao();
			loanAgreDao.InsertNewCustomer(acodto, loanAgreDto, guinfoDto);
			
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
