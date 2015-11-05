package com.system.loan;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.UserDaoImp;
import com.system.loan.dto.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	UserDaoImp userImp = null;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/","home"}, method = RequestMethod.GET)
	public String home() {
			
		return "home";
		
	}
	 
	@RequestMapping(value="customer_information")
	public String customerInformation(){
		return "customer_information";
	}

	/*
	 * @RequestMapping(value="/addUser", method=RequestMethod.POST) public
	 * String addUser(@ModelAttribute MfiUserDto user){ userImp=new
	 * MfiUserDaoImp(); userImp.insertUser(user); return "redirect:/"; }
	 */
	
	@RequestMapping(value = "/listUser", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
	public @ResponseBody java.util.List<UserDto> listUser() {
		
		//return userImp.listUser();
		return null;
	}

	@RequestMapping(value = "/addUser", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean addUser(@RequestBody UserDto user) {
		return userImp.insertUser(user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public @ResponseBody Boolean updateUser(@RequestBody UserDto user) {

		return userImp.updateUser(user);

	}

	@RequestMapping(value = "/deleteUser", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Boolean deleteUser(@RequestBody UserDto user) {

		return userImp.deleateUser(user);

	}

	@RequestMapping(value = "/updateForm/{usID}", method = RequestMethod.GET)
	public String listSpecificUser(@PathVariable("usID") Integer usID, Map<String, Object> model) {
		
		model.put("listSpecificUser", userImp.listSpecificUser(usID));
		return "update_user_test";
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
