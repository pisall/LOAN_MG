package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.GuarantorInfoDto;

public interface GuarantorDao {
	public List<GuarantorInfoDto>foundGuarantorByID(String cuID,String guID);
	public Boolean deleteGuarantor(Integer id);
	public Boolean updateGuarantor(GuarantorInfoDto guarantor); 
	public Boolean insertGuarantor(GuarantorInfoDto guarantor);
	public List<GuarantorInfoDto>listGuarantor();
}
