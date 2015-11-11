package com.system.loan;
 

import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.system.loan.dao.OutcomeDao;
 
@Entity
@Controller
@RequestMapping(value="Outcome")
public class OutcomeController {
	 	@RequestMapping(value="/OutcomeDao", produces="application/json",consumes="application/json",method=RequestMethod.POST)
	 	public @ResponseBody List<Object>OutcomeDao(){
	 		OutcomeDao outcome = new OutcomeDao();
	 		return outcome.Outcome();
	 	}
		@RequestMapping(value="/OutcomeView", method=RequestMethod.GET)
		public String Income(){
			
			return "Outcome";
		}
	}
 
