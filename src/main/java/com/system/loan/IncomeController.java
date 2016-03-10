package com.system.loan;

import javax.inject.Inject;
import javax.persistence.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.IncomeDao; 

@Entity
@Controller
@RequestMapping(value="/Income")
public class IncomeController {   
	@Inject
		IncomeDao income;
	@RequestMapping(value="/IncomeDao", produces="application/json", consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody Object IncomeDao(){
		//IncomeDao income = new IncomeDao(); 
		return income.Income(); 
	}
	@RequestMapping(value="/IncomeView", method=RequestMethod.GET)
	public String Income(Model model){
		model.addAttribute("page_id","Income");
		return "Income";
	}
}
