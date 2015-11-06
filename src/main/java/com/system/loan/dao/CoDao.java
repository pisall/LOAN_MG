/**
 * 
 */
package com.system.loan.dao;

import java.util.List;

import com.system.loan.dto.CoDto;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */
public interface CoDao {

	public List<CoDto> listCo(pagingDto paging);
	public int totalRecord(pagingDto paging);
}
