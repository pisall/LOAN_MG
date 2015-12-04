package com.system.loan;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.system.loan.dao.GuarantorDaoImp;
import com.system.loan.dao.TransectionDao;
import com.system.loan.dao.customer.CustomerDaoImp;
import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;


/**
 * Handles requests for the application home page.
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("customer")
public class CustomerController {

	@Inject
	CustomerDaoImp customerImp;
	@Inject
	GuarantorDaoImp guarantorImp;
	
	@Inject
		TransectionDao tr;

	@RequestMapping(value = "/home_customer")
	public String home_customer(Model model) {
		model.addAttribute("page_id","customer_information");
		return "customer_information";
	}
	
	/**
	 * List Customer
	 * 
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/listCus", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> listCus(@RequestBody pagingDto paging,
			@RequestParam(name = "coID", defaultValue = "") String coID) {
		tr.check_late();
		int totaPage = 0;
		totaPage = (int) Math.ceil((float) customerImp.totalCus(paging, coID) / paging.getPcnt());
		paging.setTotalPage(totaPage);
		if (paging.getTotalPage() < paging.getPageNo()) {
			paging.setPageNo(paging.getTotalPage());
		}
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("REC", customerImp.listCustomer(paging, coID));
		model.put("PAGING", paging);
		
		
		
		return model;
	}

	/**
	 * Get Customer Detail
	 * 
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/get_customer_detail/{cuID}", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody CustomerDto getCustomerDetail(@PathVariable("cuID") String cuID) {
		return customerImp.listSpecificCustomer(cuID);
	}

	/**
	 * Update Customer
	 * 
	 * @param Customer
	 * @return
	 */
	@RequestMapping(value = "/update_customer", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean updateCustomer(@RequestBody CustomerDto cus, HttpServletRequest request ) {

		return customerImp.updateCustomer(cus);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(
	    @RequestParam("uploadfile") MultipartFile uploadfile,HttpServletRequest request) {
		BufferedOutputStream stream = null;	
	 try {
	    String filename = uploadfile.getOriginalFilename();
	    byte bytes[]=uploadfile.getBytes();
	    String p="\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp12\\wtpwebapps";
	    String directory=request.getRealPath("/src/main/webapp/resources/img/");
	    String dir=directory.replace(p,"");
	    String filepath = Paths.get(dir, filename).toString();
	  
	    // Save the file locally
	    stream =
	        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
	    stream.write(bytes);
	    
	  }
	  catch (Exception e) {
	    System.out.println(e.getMessage());
	    return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	  }finally{
		  try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	  return new ResponseEntity<Object>(HttpStatus.OK);
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
	@RequestMapping(value = "/edit_customer", method = RequestMethod.GET)
	public String customerFormUpdate(@RequestParam(value = "cuID", defaultValue = "") String cuID,
			@RequestParam(value = "guID", defaultValue = "") String guID, Map<String, Object> model) {
		model.put("customer", customerImp.listSpecificCustomer(cuID));
		model.put("guarantor", guarantorImp.foundGuarantorByID(cuID, guID));
		return "customer_form_edit";
	}
	
	@RequestMapping(value = "/process_bar", method = RequestMethod.GET)
	public String processBar(){
		return "process_bar";
	}

}
