package com.system.loan;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dao.CustomerOfficerDaoImp;
import com.system.loan.dao.GuarantorDaoImp;
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
	@Inject
	GuarantorDaoImp guarantorImp;

	/**
	 * List Customer
	 * 
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/listCus/{coID}", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> listCus(@RequestBody pagingDto paging,@PathVariable("coID")int coID) {
	
		paging.setTotalPage((int) Math.ceil((float) customerImp.totalCus(paging,coID) / paging.getPcnt()));
		HashMap<String, Object> model = new HashMap<String, Object>();	
		model.put("REC", customerImp.listCustomer(paging,coID));
		model.put("PAGING", paging);
		return model;
	}

	/**
	 * Add New Customer
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/addCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean addCustomer(@RequestBody CustomerDto customer) {

		return customerImp.insertCustomer(customer);

	}

	/**
	 * Update Customer
	 * 
	 * @param Customer
	 * @return
	 */
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public @ResponseBody Boolean updateCustomer(@RequestBody CustomerDto Customer) {

		return customerImp.updateCustomer(Customer);

	}

	/**
	 * Delete Customer
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/deleteCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean deleteCustomer(@RequestBody CustomerDto customer) {

		return customerImp.deleteCustomer(customer);

	}

	/**
	 * Update Form
	 * 
	 * @param usID
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateForm/{usID}", method = RequestMethod.GET)
	public String listSpecificCustomer(@PathVariable("usID") String usID, Map<String, Object> model) {

		model.put("listSpecificCustomer", customerImp.listSpecificCustomer(usID));
		return "update_Customer_test";
	}

	/**
	 * New Customer Officer
	 * 
	 * @return
	 */
	@RequestMapping(value = "/new_co", method = RequestMethod.GET)
	public String newCo() {

		return "new_co";
	}

	/**
	 * Load page loan agreement
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customer_form_update", method = RequestMethod.GET)
	public String customerFormUpdate(@RequestParam(value = "cuID", defaultValue = "") String cuID,
			@RequestParam( value = "guID", defaultValue = "") String guID, Map<String, Object> model) {

		model.put("customer", customerImp.listSpecificCustomer(cuID));
		model.put("guarantor", guarantorImp.foundGuarantorByID(cuID, guID));

		return "customer_form_update";
	}
	

}
