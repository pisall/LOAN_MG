package com.system.loan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="test")
public class TestController {
	
	@RequestMapping(value="/test_001")
	public ModelAndView test001(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("test_send_message");
		return mv;
	}

}
