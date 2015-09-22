package com.system.loan;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.MfiUserDaoImp;
import com.system.loan.dto.MfiUserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	MfiUserDaoImp userImp=null;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Map<String, Object> model) {
	/*	userImp=new MfiUserDaoImp();
		model.put("users",userImp.listUser());*/
		return "home";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute MfiUserDto user){
		userImp=new MfiUserDaoImp();
		userImp.insertUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.GET)
	public String updateUser( @ModelAttribute MfiUserDto user){
		userImp=new MfiUserDaoImp();
		userImp.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteUser/{usID}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("usID") Integer userID){
		userImp=new MfiUserDaoImp();
		MfiUserDto user=new MfiUserDto();
		user.setUsID(userID);
		userImp.deleateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value="/updateForm/{usID}", method=RequestMethod.GET)
	public String listSpecificUser(@PathVariable("usID")Integer usID ,Map<String,Object>model){
		userImp=new MfiUserDaoImp();
		model.put("listSpecificUser",userImp.listSpecificUser(usID));
		return "update_user_test";
	}
	
	
	
}
