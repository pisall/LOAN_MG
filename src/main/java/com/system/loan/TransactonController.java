package com.system.loan;

import java.io.Serializable; 
import java.util.Map;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.system.loan.dao.ApproveTransactionDao; 

@Controller
@RequestMapping(value="/schadule_payment")
public class TransactonController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@RequestMapping(value="/schadule/{tr_id}/{cu_id}", produces="application/json", consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody Object SchadulePayment(@PathVariable("tr_id") Integer  tr_id , @PathVariable("cu_id") Integer  cu_id) {  
		ApproveTransactionDao schaPay = new ApproveTransactionDao(); 
		return schaPay.Schadule_Payment(tr_id, cu_id);
	} 
	
	@RequestMapping(value="/loanApprove",method = RequestMethod.GET)
	public String loanApproval(WebRequest request){ 
		return "loan_approve";
	}
	 
}



