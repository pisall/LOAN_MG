package com.system.loan.dao;

import com.system.loan.dto.LoanApprovalDto;

public interface LoanApprovalInterface {
	public boolean LoanApro_Insert(LoanApprovalDto loaApro);
	public boolean TranSac_Update(int tr_id, String tr_type);
}
