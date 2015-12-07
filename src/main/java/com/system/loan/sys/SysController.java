package com.system.loan.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sys")

public class SysController {

	@RequestMapping(value="/sys_form",method=RequestMethod.GET)
	public ModelAndView sysForm(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sys_reg");
		
		return mv;
	}

}
