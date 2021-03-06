package com.system.loan.co;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationContextLocator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.loan.HomeController;
import com.system.loan.dao.myUserDetailsManager;
import com.system.loan.dao.co.CO_DAO_001_IMP;
import com.system.loan.dao.login.LOGIN_DAO_001_IMP;
import com.system.loan.dto.pagingDto;
import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.co.in.co_0001_in;
import com.system.loan.dto.co.in.co_0002_in;
import com.system.loan.dto.login.in.login_0001_in;
import com.system.loan.dto.session.USER_SESSION;

@Controller
@RequestMapping("co_001_controller")
public class co_001_controller {
	@Inject 
	CO_DAO_001_IMP coDao;
	@Inject
	LOGIN_DAO_001_IMP loginDao;
	/*
	 * view add new customer
	 */
	@RequestMapping(value="/co_0001",method=RequestMethod.GET)
	public ModelAndView co001(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_officer_add");
		mv.addObject("page_id", "co_0003");
		//CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		HashMap<String, Object> test=new HashMap<>();
		test=coDao.findLogByLogMail("mnee");
//		System.out.println(test.get("log_email"));//
		
		return mv;
	}
	/*
	 * view customer officer detail
	 */
	@RequestMapping(value="/co_0002",method=RequestMethod.GET)
	public String co0001(HttpServletRequest req){
		return "customer_officer_detail";
	}
	
	/*
	 * view customer officer list
	 */
	@RequestMapping(value="/co_0003",method=RequestMethod.GET)
	public ModelAndView co0003(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_officer_list");
		mv.addObject("page_id","co_0003");
		return mv;
	}
	/*
	 * view customer officer update
	 */
	@RequestMapping(value="/co_0004/{id}",method=RequestMethod.GET)
	public ModelAndView co0004(@PathVariable int id,HttpServletRequest req){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer_officer_edit");
		modelAndView.addObject("id", id);
		modelAndView.addObject("page_id","co_0003");
		
		return modelAndView;
	}
	
	/*
	 * insert new  customer officer
	 */
	@RequestMapping(value="/co_c0001",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> coR0001(@RequestBody co_0001_in input,HttpServletRequest req){
		HashMap<String, Object> result=new HashMap<String, Object>();
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		int sesCoId=user.getCoId();
		
		String regDate="";
		
		/*
		 * get current date and time
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		regDate=dateFormat.format(date);
		System.out.println(regDate); //2014/08/06 15:59:48
		
		/*
		 * @parameter log_email if user log in null
		 */
		if(input.getLog_email()==null || input.getLog_email().isEmpty() || input.getLog_email()==""){
			result.put("CODE", "0001");
			result.put("MESSAGE","log id is required");
			return result;
		}
		
		/*
		 * @parameter national id if null
		 */
		if(input.getCo_national_id()==null || input.getCo_national_id().isEmpty()||input.getCo_national_id()==""){
			result.put("CODE", "0001");
			result.put("MESSAGE","national id is required");
			return result;
		}
		
		/*
		 * @parameter password is null
		 */
		
		if(input.getLog_password()==null || input.getLog_password().isEmpty() || input.getLog_password().equals("")){
			result.put("CODE", "0001");
			result.put("MESSAGE","password is required");
			return result;
		}
		
		/*
		 * @parameter password if password match
		 */
		if(!input.getConfirm_password().equals(input.getLog_password())){
			result.put("CODE", "0001");
			result.put("MESSAGE","password is no match");
			return result;
		}
		
		/*
		 * initialize co object
		 */
		CO_DTO_001 co=new CO_DTO_001();
		co.setCo_first_nm(input.getCo_first_nm());
		co.setCo_last_nm(input.getCo_last_nm());
		co.setCo_sex(input.getCo_sex());
		co.setCo_brand(input.getCo_brand());
		co.setCo_cpm_phone(input.getCo_cpm_phone());
		co.setCo_phone(input.getCo_phone());
		co.setDob(input.getDob());
		co.setAddress(input.getAddress());
		co.setCo_pb_address(input.getCo_pb_address());
		co.setReg_dtt(regDate);
		co.setUpdate_dtt("");
		co.setCo_national_id(input.getCo_national_id());
		//co.getRegCo().se
		
		/*
		 * initialize login object
		 */
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String hashedPassword = passwordEncoder.encode(input.getLog_password());
		
		System.out.println(hashedPassword);
		LOGIN_DTO_001 log=new LOGIN_DTO_001();
		log.setLog_email(input.getLog_email());
		log.setLog_password(hashedPassword);
		log.setLog_type("ROLE_USER");
		log.setEnabled(true);
		
		
		//insert process
		HashMap<String, Object>  insertResult=coDao.newCoLog(co,log,sesCoId);
		
		if((boolean) insertResult.get("ERROR")){
			result.put("CODE", "0001");
			result.put("MESSAGE",insertResult.get("MESSAGE"));
		}
		
		return result;
		
		
	}
	
	/*
	 * list customer officer
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/co_l0001",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coL0001(@RequestBody pagingDto paging,HttpServletRequest req){
		//CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		HashMap<String, Object> result=new HashMap<>();
		HttpSession session=req.getSession();
		String test=(String)session.getAttribute("username");
		System.out.println("session naem="+test);
		pagingDto newpaging=new pagingDto();
		newpaging=coDao.getPaging(paging);
		result.put("PAGING", newpaging);
		List rec=coDao.coList(newpaging);
		result.put("REC", rec);
		return result;
	}
	
	/*
	 * get record customer official detail by id
	 */
	
	@RequestMapping(value="/co_l0002",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String , Object> coL002(@RequestBody co_0002_in input,HttpServletRequest req){
		HashMap<String, Object> result=coDao.findCoById2(input.getCo_id());
		
		return result;
	}
	/*
	 * disable or enable user by update filed enabled in table mfi_login
	 */
	
	@RequestMapping(value="/co_u0001",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coU0001(@RequestBody co_0002_in input,HttpServletRequest req){
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		int sesCoId=user.getCoId();
		List<Integer> listId=new ArrayList<>();
		
		HashMap<String, Object> result=new HashMap<>();
		result.put("CODE", "0000");
		result.put("MESSAGE","");
		
		int coId=input.getCo_id();
		if(coId==0){
			result.put("CODE", "0001");
			result.put("MESSAGE","");
		}else if(coId>0){
			
			//check if user disable own self
			if(sesCoId==coId){
				result.put("CODE", "0001");
				result.put("MESSAGE","Request is not avaliable.");
			}
		}
		HashMap<String, Object> exe=new HashMap<>();
		
		if(result.get("CODE").toString().equals("0000")){
			System.out.println("start exe");
			listId.add(input.getCo_id());
			
			exe=coDao.updateEnabledUser(listId, input.isEnabled());
			if((boolean)exe.get("ERROR")){
				result.put("CODE", "0001");
				result.put("MESSAGE","False to process.");
			}
		}
		
		
		return result;
	}
	/*
	 * enabled user
	 */
	@RequestMapping(value="/co_u0004",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coU0004(@RequestBody List<co_0002_in> input,HttpServletRequest req){
		HashMap<String, Object> result=new HashMap<String, Object>();
		HashMap<String, Object> exe=new HashMap<String, Object>();
		List listId=new ArrayList<Integer>();
		for(co_0002_in item:input){
			listId.add(item.getCo_id());
		}
			exe=coDao.updateEnabledUser(listId, true);
			if((boolean)exe.get("ERROR")){
				result.put("ERROR", true);
				result.put("MESSAGE","False to process.");
			}else{
				result.put("ERROR", false);
				result.put("MESSAGE","Restoring is successful.");
			}
		
		
		return result;
	}
	
	
	@RequestMapping(value="/co_u0002",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coU0002(@RequestBody co_0001_in input){
		System.out.println("service::co_u0002");
		System.out.println(input.toString());
		
		return null;
	}
	
	/*
	 * profile detail
	 */
	
	@RequestMapping(value="/co_0005",method=RequestMethod.GET)
	public ModelAndView co0005(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("profile_detail");
		mv.addObject("page_id","co_0005");
		return mv;
	}
	/**
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/co_l0003",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> coL0003(HttpServletRequest req){
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		int sesCoId=user.getCoId();
		
		HashMap<String, Object> result=coDao.findCoById2(sesCoId);
		return result;
	}
	/*
	 * update co by id 
	 * if id is not equal id from session, it is checked whether this id is allowed to edit;
	 */
	@RequestMapping(value="/co_u0003",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> coU0003(@RequestBody co_0001_in input,HttpServletRequest req){
	
		HashMap<String, Object> updateUserLogin=new HashMap<>();
		HashMap<String , Object> result=new HashMap<>();
		HashMap<String, Object> updateCo=new HashMap<>();
		//update login user
		
		LOGIN_DTO_001 login = new LOGIN_DTO_001();
		login.setLog_in(input.getLog_in());
		login.setLog_email(input.getLog_email());
		login.setLog_password(input.getLog_password());
		login.setLog_type(input.getLog_type());
		updateUserLogin=loginDao.updateLogin(login,req);
		
		//update co
		updateCo=coDao.updateCo(input,req);
		if((boolean)updateCo.get("ERROR")){
			//update login 
			result.put("ERROR", true);
			result.put("MESSAGE",updateCo.get("MESSAGE"));
//		}else if((boolean)updateUserLogin.get("ERROR")){
//			result.put("ERROR", true);
//			result.put("MESSAGE",updateUserLogin.get("MESSAGE"));
		}else{
			result.put("ERROR", false);
		}
		return result;//test
	}
	/*
	 * view who register profile
	 */
	@RequestMapping(value="/co_l0004",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coL0003(@RequestBody co_0002_in input ){
		HashMap<String, Object> result=new HashMap<>();
		result=coDao.getCoLeftJoinLogById(input.getCo_id());
		return result;
	}
	
	/*
	 * update profile
	 */
	
	@RequestMapping(value="/co_u0005",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coU0005(@RequestBody co_0001_in input,HttpServletRequest req){
		
		HashMap<String, Object> result=new HashMap<String, Object>();
		HttpSession session=req.getSession();
		USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
		int sesCoId=user.getCoId();
		result.put("CODE", "0000");
		
		String regDate="";
		
		/*
		 * get current date and time
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		regDate=dateFormat.format(date);
		
		/*
		
		
		/*
		 * @parameter national id if null
		 */
		if(input.getCo_national_id()==null || input.getCo_national_id().isEmpty()||input.getCo_national_id()==""){
			result.put("CODE", "0001");
			result.put("MESSAGE","national id is required");
			return result;
		}
		
		/*
		 * @parameter phone is null
		 */
		
		if(input.getCo_phone()==null || input.getCo_phone().isEmpty()||input.getCo_phone()==""){
			result.put("CODE", "0001");
			result.put("MESSAGE","phone is required");
			return result;
		}
		input.setCo_id(sesCoId);
		input.setUpdate_dtt(regDate);
		result=coDao.updateProfile(input);
		
		
		//input.set
		
		System.out.println("this is result:="+result.toString());
		
		
		
		return result;
	}
	@RequestMapping(value="/privacy_view",method=RequestMethod.GET)
	public ModelAndView privacyView(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("privacy");
		mv.addObject("page_id", "privacy_view");
		return mv;
	}
	
	//list co trush 
	@RequestMapping(value="co_l0005",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> coL0005(@RequestBody pagingDto paging){
		
		HashMap<String, Object> result=new HashMap<>();
		pagingDto newpaging=new pagingDto();
		newpaging=coDao.getPangingTrush(paging);
		result.put("PAGING", newpaging);
		List rec=coDao.coTrushList(newpaging);
		result.put("REC", rec);
		
		return result;
	}
	
	@RequestMapping(value="/co_0006",method=RequestMethod.GET)
	public ModelAndView co0006(HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_officer_trush_list");
		mv.addObject("page_id","co_0003");
		return mv;
	} 
	
	

}
