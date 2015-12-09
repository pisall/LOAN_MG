package com.system.loan.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;

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
	
	@RequestMapping(value = "/report_late")
	public String reportLate(Model model){
	model.addAttribute("page_id", "cont_7");
    return "loan_late";
}
	
	/**
	 * List Customer
	 * 
	 * @param paging
	 * @return
	 */

	@RequestMapping(value = "/list_expend_report", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> listExpendReport(@RequestBody pagingDto paging,
			@RequestParam(name = "coID", defaultValue = "") String coID) {
		int totaPage = 0;
		int total=report.totalExpendReport(paging, coID);
		totaPage = (int) Math.ceil((float) total / paging.getPcnt());
		paging.setTotalPage(totaPage);
		if (paging.getTotalPage() < paging.getPageNo()) {
			paging.setPageNo(paging.getTotalPage());
		}
		HashMap<String, Object> model = new HashMap<String, Object>();
		paging.setTotal(total);
		model.put("REC", report.listExpendreport(paging, coID));
		model.put("PAGING", paging);
		model.put("TOTAL_AMOUNT", report.getTotalIncomeOutcome(coID, paging));
		return model;
	}
	
	@RequestMapping(value = "/report_loan_late", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> reportLoanLate(@RequestBody pagingDto paging,@RequestParam(name = "coID", defaultValue = "") String coID){
		int totaPage = 0,total=0;
		total=report.getTotalLoanLate(paging, coID);
		totaPage = (int) Math.ceil((float) total / paging.getPcnt());
		paging.setTotalPage(totaPage);
		if (paging.getTotalPage() < paging.getPageNo()) {
			paging.setPageNo(paging.getTotalPage());
		}
		paging.setTotal(total);
		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("REC", report.listReportLate(paging, coID));
		model.put("PAGING", paging);
		return model;
	}
}
