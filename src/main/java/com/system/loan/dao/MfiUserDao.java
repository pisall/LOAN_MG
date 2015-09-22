package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.MfiUserDto;

public interface MfiUserDao {
	public Boolean updateUser(MfiUserDto user);
	public Boolean insertUser(MfiUserDto user);
	public Boolean deleateUser(MfiUserDto user);
	public List<MfiUserDto> listUser();
}
