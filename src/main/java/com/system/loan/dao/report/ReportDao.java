package com.system.loan.dao.report;

import java.util.List;

import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.pagingDto;

public interface ReportDao {
	public List<AcountInfoDto>listExpendreport(pagingDto paging, String coID);
}
