package com.system.loan;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.HttpContext;
import com.system.loan.dto.session.USER_SESSION;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/","home"}, method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		String test=user.getCoNm();
		System.out.println("session naem="+test); 
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
