package com.system.loan;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dao.CustomerOfficerDaoImp;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.CustomerOfficerDto;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("customer_officer")
public class CustomerOfficerController {
	
	@Inject
	CustomerOfficerDaoImp coImp;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list_customer_officer", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<CustomerOfficerDto> listCustomer() {
		
		return coImp.listCustomerOfficer();
	}
	
	
	

}
