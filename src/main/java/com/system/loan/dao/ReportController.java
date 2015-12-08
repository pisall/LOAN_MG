package com.system.loan.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.report.ReportDaoImp;
import com.system.loan.dto.pagingDto;

@Controller
@RequestMapping(value="report")
public class ReportController {
	
	@Inject
		ReportDaoImp report;
	
	@RequestMapping(value="/report_loan")
	public String report(Model model){
		model.addAttribute("page_id","report_loan");
		return "report_loan"; 
	}
	
	@RequestMapping(value="/loan_late")
	public String loan_late(Model model){
		model.addAttribute("page_id","report_loan");
		return "loan_late"; 
	}
	
	/**
	 * List Customer
	 * 
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/list_expend_report", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> listCus(@RequestBody pagingDto paging,
			@RequestParam(name = "coID", defaultValue = "") String coID) {
		int totaPage = 0;
		totaPage = (int) Math.ceil((float) report.totalExpendReport(paging, coID) / paging.getPcnt());
		paging.setTotalPage(totaPage);
		if (paging.getTotalPage() < paging.getPageNo()) {
			paging.setPageNo(paging.getTotalPage());
		}
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("REC", report.listExpendreport(paging, coID));
		model.put("PAGING", paging);
		model.put("TOTAL_AMOUNT", report.getTotalIncomeOutcome(coID, paging));
		//model.put("SUB_AMOUNT", report.getSubTotal(coID, paging));
		return model;
	}
}
