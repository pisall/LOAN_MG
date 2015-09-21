package com.system.loan;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.MfiUserImp;
import com.system.loan.dto.MfiUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	MfiUserImp userImp=null;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Map<String, Object> model) {
		userImp=new MfiUserImp();
		List<MfiUser> users = userImp.listUser();
		System.out.println("LIST COUNT==="+ users.size());
		for(MfiUser user : users){
			System.out.println(user.getUsID());
			System.out.println(user.getUsEmail());
		}
		model.put("users",users);
		return "home";
	}
	
	/*@RequestMapping(value="/listUser", method=RequestMethod.POST)
	public String listUser(Model model){
		userImp=new MfiUserImp();
		model.addAttribute("listUser",userImp.listUser());
		return "home";
	}*/
	
}
