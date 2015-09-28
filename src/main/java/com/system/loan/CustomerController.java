package com.system.loan;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.MfiUserDaoImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {
	
	@Inject
	MfiUserDaoImp userImp = null;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/","home"}, method = RequestMethod.GET)
	public String home() {
			
		return "home";
		
	}
	

}
