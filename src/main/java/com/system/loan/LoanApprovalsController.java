package com.system.loan;
 
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.LoanApprovalDao; 
import com.system.loan.dto.LoanApprovalDto;

@Controller
@RequestMapping(value="loan")
public class LoanApprovalsController implements Serializable{
 
	private static final long serialVersionUID = 1L;
	LoanApprovalDao loanApproDao = null;
	
	@RequestMapping(value="/loanApprove/{tr_id}/{tr_type}", produces="application/json", consumes="application/json", method=RequestMethod.POST)
	public @ResponseBody boolean loanApproval(@RequestBody LoanApprovalDto loanApproDto, @PathVariable("tr_id") Integer  tr_id , @PathVariable("tr_type") String  tr_type){
		
		loanApproDao = new LoanApprovalDao();  
		loanApproDao.LoanApro_Insert(loanApproDto);
		loanApproDao.TranSac_Update(tr_id, tr_type);
		
	return true; 
	} 
}



