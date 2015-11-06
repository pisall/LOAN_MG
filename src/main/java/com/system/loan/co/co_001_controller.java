package com.system.loan.co;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.loan.dao.co.CO_DAO_001_IMP;
import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.co.in.co_0001_in;
import com.system.loan.dto.co.in.co_0002_in;

@Controller
@RequestMapping("co_001_controller")
public class co_001_controller {
	
	/*
	 * view add new customer
	 */
	@RequestMapping(value="/co_0001",method=RequestMethod.GET)
	public String co001(){
		CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		HashMap<String, Object> test=new HashMap<>();
		test=coDao.findLogByLogMail("mnee");
		System.out.println(test.get("log_email"));
		return "customer_officer_add";
	}
	/*
	 * view customer officer detail
	 */
	@RequestMapping(value="/co_0002",method=RequestMethod.GET)
	public String co0001(){
		return "customer_officer_detail";
	}
	
	/*
	 * view customer officer list
	 */
	@RequestMapping(value="/co_0003",method=RequestMethod.GET)
	public String co0003(){
		return "customer_officer_list";
	}
	/*
	 * view customer officer update
	 */
	@RequestMapping(value="/co_0004/{id}",method=RequestMethod.GET)
	public ModelAndView co0004(@PathVariable int id ){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer_officer_edit");
		modelAndView.addObject("id", id);
		
		return modelAndView;
	}
	
	/*
	 * insert new  customer officer
	 */
	@RequestMapping(value="/co_c0001",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> coR0001(@RequestBody co_0001_in input){
		HashMap<String, Object> result=new HashMap<String, Object>();
		System.out.println("controller::co_001_controller/co_c0001");
		
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
		log.setLog_type("ROLE_ADMIN");
		
		CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		
		//insert process
		HashMap<String, Object>  insertResult=coDao.newCoLog(co,log);
		
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
	public List coL0001(){
		CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		
		return coDao.coList();
	}
	
	/*
	 * get record customer official detail by id
	 */
	
	@RequestMapping(value="/co_l0002",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String , Object> coL002(@RequestBody co_0002_in input){
		System.out.println("controller::co_001_controller/co_c0001");
		CO_DAO_001_IMP coDao=new CO_DAO_001_IMP();
		HashMap<String, Object> result=coDao.findCoById2(input.getCo_id());
		
		return result;
	}
	

}
