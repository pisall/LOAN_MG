package com.system.loan.sys;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.system.loan.dao.co.CO_DAO_001_IMP;
import com.system.loan.dto.co.in.co_0001_in;
import com.system.loan.sys.dao.SysConfig;

@Controller
@RequestMapping("sys")

public class SysController {
	
	@Inject 
	SysConfig sysDao;

	@RequestMapping(value="/sys_form",method=RequestMethod.GET)
	public ModelAndView sysForm(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sys_reg");
		return mv;
	}
	
	
	@RequestMapping(value="/sys_req",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> sysReq(@RequestBody co_0001_in input){
		System.out.println("start request="+input.toString());
		
		HashMap<String, Object> result=new HashMap<>();
		result.put("test", "you");
		
		result=sysDao.addSysUser(input);
		
		return result;
	}

}
