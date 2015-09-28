package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.CustomerDto;

public interface CustomerDao {
	public Boolean updateCustomer(CustomerDto cus);
	public Boolean insertCustomer(CustomerDto cus);
	public Boolean deleateCustomer(CustomerDto cus);
	public List<CustomerDto> listCustomer();
}
