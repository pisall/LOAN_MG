package com.system.loan;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/listGuarantorByID", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody List listGuarantorByID(@RequestBody GuarantorInfoDto gu) {

		String cuID = gu.getCustomerDto().getCuID() + "";
		String guID = gu.getGu_id() + "";

		return guarantor.foundGuarantorByID(cuID, guID);
	}

}
