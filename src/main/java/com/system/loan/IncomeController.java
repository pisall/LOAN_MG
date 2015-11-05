package com.system.loan;

import javax.persistence.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Entity
@Controller
@RequestMapping(value="/Income")
public class IncomeController {   

	@RequestMapping(value="/IncomeView", method=RequestMethod.GET)
	public String Income(){
		return "IncomeView";
	}
}
