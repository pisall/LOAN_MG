package com.system.loan;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.naming.directory.DirContext;
import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.http.HttpRequest;
import org.springframework.ldap.core.ContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.HttpContext;
import com.system.loan.dao.CustomerDaoImp;
import com.system.loan.dao.CustomerOfficerDaoImp;
import com.system.loan.dao.LdapUserDetailsManager;
import com.system.loan.dao.myUserDetailsManager;
import com.system.loan.dao.login.LOGIN_DAO_001_IMP;
import com.system.loan.dto.login.in.login_0001_in;
import com.system.loan.dto.session.USER_SESSION;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject 
	LOGIN_DAO_001_IMP loginDao;
	@Inject
		CustomerOfficerDaoImp co;
	@Inject
		CustomerDaoImp cu;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/","home"}, method = RequestMethod.GET)
	public String home(HttpServletRequest req,Model model) {
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		String test=user.getCoNm();
		model.addAttribute("totalCo",co.getTotalCustomerOfficer());
		model.addAttribute("totalCu",cu.getTotalCustomer());
		
		return "home"; 
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("username", "prak");
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
			System.out.println("user name="+userName);
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String , Object> changePassword(@RequestBody login_0001_in input){
		
		HashMap<String, Object> result=new HashMap<>();
//		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String userName=principal.toString();
//		if(principal instanceof UserDetails){
//			userName=((UserDetails)principal).getUsername();
//			System.out.println("userName="+userName+ ","+((UserDetails)principal).getPassword());
//			
//		}
//		
//		HashMap<String, Object> changeResult=loginDao.changePassword(input, userName);
//		if((boolean)changeResult.get("ERROR")){
//			result.put("ERROR", true);
//		}else{
//			result.put("ERROR", false);
//		}
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		AuthenticationManager au=new 
//		
//		String name = SecurityContextHolder.getContext().getAuthentication().toString();
//
//		try {
//			auth.isAuthenticated();
//		    // Update password here with your dao
//		} catch (AuthenticationException e) {
//		    // Old password was wrong
//		}
		
		//UserDetails matchingUser=user
		
		UserDetailsManager userMg=new myUserDetailsManager();
		userMg.changePassword(input.getOldPassword(), input.getNewPassword());
		
		
		return result;
		
		
	}
	@RequestMapping(value="/log_0001",method=RequestMethod.GET)
	public ModelAndView log0001(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("account_setting");
		return mv;
	}
	 
	
	/*
	
	@RequestMapping(value="customer_information")
	public ModelAndView customerInformation(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_information");
		mv.addObject("page_id","customer_information");
		return mv;
	}

	
	 * @RequestMapping(value="/addUser", method=RequestMethod.POST) public
	 * String addUser(@ModelAttribute MfiUserDto user){ userImp=new
	 * MfiUserDaoImp(); userImp.insertUser(user); return "redirect:/"; }
	 
	


	@RequestMapping(value = "/new_co", method = RequestMethod.GET)
	public String newCo() {

		return "new_co";
	}

	@RequestMapping(value = "/loan_agreement", method = RequestMethod.GET)
	public String loanAgreement() {

		return "loan_agreement";
	}*/
	
	
}
