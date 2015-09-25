/**
 * 
 */
package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.MfiCoDto;
import com.system.loan.dto.MfiUserDto;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */
public interface MfiCoDao {

	public List<MfiCoDto> listCo(pagingDto paging);
}
