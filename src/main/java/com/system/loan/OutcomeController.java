package com.system.loan;
 

import javax.persistence.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Entity
@Controller
@RequestMapping(value="Outcome")
public class OutcomeController {
	 
		@RequestMapping(value="/OutcomeView", method=RequestMethod.GET)
		public String Income(){
			
			return "Outcome";
		}
	}
 
