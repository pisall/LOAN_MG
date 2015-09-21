package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.MfiUser;

public interface MfiUserDao {
	public Boolean updateUser(MfiUser user);
	public Boolean insertUser(MfiUser user);
	public Boolean deleateUser(MfiUser user);
	public List<MfiUser> listUser();
}
