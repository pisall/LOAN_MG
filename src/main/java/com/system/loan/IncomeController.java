package com.system.loan;

import javax.persistence.Entity;
 
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@RequestMapping(value="Income")
public class IncomeController {

	@RequestMapping(value="/IncomeView")
	String Income(){
		return "Income/IncomeView";
	}
}
