package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.CustomerDto;
import com.system.loan.dto.pagingDto;

public interface CustomerDao {
	public Boolean updateCustomer(CustomerDto cus);
	public Boolean insertCustomer(CustomerDto cus);
	public Boolean deleteCustomer(CustomerDto cus);
	public List<CustomerDto> listCustomer(pagingDto paging,String coID);
}
