/**
 * 
 */
package com.system.loan;

import java.util.Map;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.loan.dao.MfiCoDaoImp;
import com.system.loan.dao.MfiUserDaoImp;
import com.system.loan.dto.pagingDto;

/**
 * @author PC_VIRAK
 *
 */

@Controller

@RequestMapping("cocontroller")
public class CoController {
	@RequestMapping(value = "/co_list", method = RequestMethod.GET)
	public String coList(Map<String,Object> model){
		System.out.println("no parameter");
		MfiCoDaoImp co=new MfiCoDaoImp();
		pagingDto paging=new pagingDto();
		paging.setPageNo(0);
		paging.setPcnt(1);
		//co.listCo();
		String filter=" limit 0,5";
		model.put("listCo", co.listCo(paging));
		model.put("paging",paging);
		return "customer_officer";
	}
	@RequestMapping(value = "/co_list/{pageNo}/{sw}", method = RequestMethod.GET)
	public String coList(@PathVariable("pageNo") Integer pno,@PathVariable("sw") String SW){
		System.out.println("page no="+ pno + "search word="+SW);
		
		return "customer_officer";
	}
	
	@RequestMapping(value = "/co_list/{pageNo}", method = RequestMethod.GET)
	public String coList(@PathVariable("pageNo") Integer pno,Map<String,Object> model){
		System.out.println("parameter page no");
		MfiCoDaoImp co=new MfiCoDaoImp();
		pagingDto paging=new pagingDto();
		paging.setPageNo(pno);
		paging.setPcnt(1);
		//co.listCo();
		String filter=" limit 0,5";
		model.put("listCo", co.listCo(paging));
		model.put("paging",paging);
		return "customer_officer";		
		
	}

}
