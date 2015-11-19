package com.system.loan.dao.login;

import java.util.HashMap;

import com.system.loan.dto.co.LOGIN_DTO_001;
import com.system.loan.dto.login.in.login_0001_in;

public interface LOGIN_DAO_001 {
	public HashMap<String, Object> changePassword(login_0001_in input,String userName);
	public LOGIN_DTO_001 getLoginByUserName(String userName);
	public int getUserIdByUserName(String userName);

}
