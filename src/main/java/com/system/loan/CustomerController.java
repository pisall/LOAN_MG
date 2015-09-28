package com.system.loan;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dao.UserDaoImp;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Inject
	CustomerDaoImp customerImp;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/listCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
	public @ResponseBody String listCustomer() {
		customerImp.listCustomer();
		return "customer_information";
	}
	
	
	

}
