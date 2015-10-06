package com.system.loan;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.GuarantorDaoImp;
import com.system.loan.dto.GuarantorInfoDto;

@Controller
@RequestMapping("guarantor")
public class GuarantorController {
	@Inject
	GuarantorDaoImp guarantor;

	/**
	 * Load page loan agreement
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listGuarantorByID", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody List listGuarantorByID(@RequestBody GuarantorInfoDto gu) {
		System.out.println("guarantor=====================" + gu.getGu_id() + gu.getCustomerDto().getCuID());
		return guarantor.foundGuarantorByID("52", "32");
	}

}
