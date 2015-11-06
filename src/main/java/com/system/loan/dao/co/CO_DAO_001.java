package com.system.loan.dao.co;

import java.util.HashMap;
import java.util.List;

import com.system.loan.dto.co.CO_DTO_001;
import com.system.loan.dto.co.LOGIN_DTO_001;

public interface CO_DAO_001 {
	public HashMap<String, Object> newCoLog(CO_DTO_001 CO,LOGIN_DTO_001 LOG);
	public int countByLogId(String LogEmail);
	public CO_DTO_001  findCoById(int id);
	@SuppressWarnings("rawtypes")
	public List coList();
	public HashMap<String, Object> findCoById2(int id);
	public HashMap<String, Object> findLogByLogMail(String email);

}
