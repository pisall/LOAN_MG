package com.system.loan;
 

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.system.loan.dao.OutcomeDao;
 
@Entity
@Controller
@RequestMapping(value="/Outcome")
public class OutcomeController {
	@Inject
		OutcomeDao outcome;
	 	@RequestMapping(value="/OutcomeDao", produces="application/json", consumes="application/json", method = RequestMethod.POST)
	 	public @ResponseBody Object OutcomeDao(){
	 		//OutcomeDao outcome = new OutcomeDao();
	 		return outcome.Outcome();
	 	}
		@RequestMapping(value="/OutcomeView", method=RequestMethod.GET)
		public String Income(Model model){
			model.addAttribute("page_id","cont_5");
			return "Outcome";
		}
	}
 
