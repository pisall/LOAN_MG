package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.UserDto;

public interface UserDao {
	public Boolean updateUser(UserDto user);
	public Boolean insertUser(UserDto user);
	public Boolean deleateUser(UserDto user);
	public List<UserDto> listUser();
}
