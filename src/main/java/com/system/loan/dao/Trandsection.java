package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.TransectionDto;
import com.system.loan.dto.UserDto;

public interface Trandsection { 
	public boolean InsertTransection(TransectionDto tranDto); 
	public List<TransectionDto> ShowReport(int cus_id);
	public List<TransectionDto> Customer_Report(int cus_id);
}
