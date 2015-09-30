package com.system.loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.system.loan.dao.CoDaoImp;
import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.UserDto;
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
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/listCustomer", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<CustomerDto> listCustomer() {
		
		return customerImp.listCustomer();
	
	}

	@RequestMapping(value = "/listCus", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> listCus(@RequestBody pagingDto paging){
		
		paging.setPcnt(2);
		paging.setTotalPage((int)Math.ceil((float)customerImp.totalCus(paging)/paging.getPcnt()));
		HashMap<String, Object> model=new HashMap<String, Object>();
		
		model.put("REC", customerImp.listCus(paging));
		model.put("PAGING", paging);
		
		return model;
	}
	
}
