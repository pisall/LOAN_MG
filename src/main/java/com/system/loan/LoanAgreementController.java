package com.system.loan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.LoanAgreementDao;
import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoDto;
import com.system.loan.dto.LoanAgreementDto;

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreementController {
		 
		//String username = request.getParameter("us_name"); 
		
		LoanAgreementDao loanAgreDao = null;
		@RequestMapping(value="/newLoanAgreement" , method=RequestMethod.GET)
		public String newLoanAgreement(){
			
			return "loan_agreement";
		}
		
		@RequestMapping(value="/newLoanAgreementGetData" , method=RequestMethod.POST)
		public String newLoanAgreement(@ModelAttribute("AcountInfoDto") AcountInfoDto acodto , @ModelAttribute("GuarantorInfoDto")GuarantorInfoDto guinfoDto,  @ModelAttribute("LoanAgreementDto")LoanAgreementDto loanAgreDto){
		 
			System.out.println("Customer Name:="+loanAgreDto.getCu_nm());
			System.out.println("Guarantor name:="+guinfoDto.getGu_nm());
			System.out.println("AMOUNT :="+acodto.getAc_amount());
		
			loanAgreDao = new LoanAgreementDao();
			loanAgreDao.InsertNewCustomer(acodto, loanAgreDto, guinfoDto);
			//return "loan_agreement";
			return "redirect:/LoanAgreement/home";
		}  
		
		@RequestMapping(value="/home")
		public String SchedulePayment(){
			
			return "home";
		}
		/*@RequestMapping(value="/send_email")
		public String customerOfficer(){
			return "send_email";
		}
		@RequestMapping(value="/mail")
		public String loanIncome(){
			return "mail";
		}*/
		 
}
