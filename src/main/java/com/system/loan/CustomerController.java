package com.system.loan;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dto.CustomerDto;

import com.system.loan.dto.pagingDto;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

	@Inject
	CustomerDaoImp customerImp;
	
	/**
	 * List Customer
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/listCus", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> listCus(@RequestBody pagingDto paging){
		
		paging.setPcnt(10);
		paging.setTotalPage((int)Math.ceil((float)customerImp.totalCus(paging)/paging.getPcnt()));
		HashMap<String, Object> model=new HashMap<String, Object>();
		
		model.put("REC", customerImp.listCustomer(paging));
		model.put("PAGING", paging);
		
		return model;
	}
	
	@RequestMapping(value = "/addCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean addCustomer(@RequestBody CustomerDto Customer) {

		return customerImp.insertCustomer(Customer);

	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public @ResponseBody Boolean updateCustomer(@RequestBody CustomerDto Customer) {

		return customerImp.updateCustomer(Customer);

	}

	@RequestMapping(value = "/deleteCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean deleteCustomer(@RequestBody CustomerDto customer) {

		return customerImp.deleateCustomer(customer);

	}

	@RequestMapping(value = "/updateForm/{usID}", method = RequestMethod.GET)
	public String listSpecificCustomer(@PathVariable("usID") Integer usID, Map<String, Object> model) {
		
		model.put("listSpecificCustomer", customerImp.listSpecificCustomer(usID));
		return "update_Customer_test";
	}

	@RequestMapping(value = "/new_co", method = RequestMethod.GET)
	public String newCo() {

		return "new_co";
	}

	@RequestMapping(value = "/loan_agreement", method = RequestMethod.GET)
	public String loanAgreement() {

		return "loan_agreement";
	}
	
	
	
	
}
