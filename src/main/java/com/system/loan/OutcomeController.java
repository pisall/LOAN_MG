package com.system.loan;

import javax.persistence.Entity;

import org.springframework.web.bind.annotation.RequestMapping;

public class OutcomeController {
	@Entity
	@RequestMapping(value="Outcome")
	public class IncomeController {

		@RequestMapping(value="OutcomeView")
		String Income(){
			return "Income/OutcomeView";
		}
	}

}
