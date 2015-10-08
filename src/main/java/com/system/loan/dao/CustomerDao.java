package com.system.loan.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

public interface CustomerDao {
	public Boolean updateCustomer(CustomerDto cus);
	public Boolean insertCustomer(CustomerDto cus);
	public Boolean deleateCustomer(CustomerDto cus);
	public List<CustomerDto> listCustomer(pagingDto paging,int coID);
}
