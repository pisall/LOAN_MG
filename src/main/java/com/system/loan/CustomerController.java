package com.system.loan;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.UserDaoImp;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Inject
	UserDaoImp userImp = null;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ="/listCustomer", method = RequestMethod.GET)
	public String listCustomer() {
			
		return "home";
		
	}
	
	
	

}
