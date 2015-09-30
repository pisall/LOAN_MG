/**
 * 
 */
package com.system.loan;

import java.util.Map;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.system.loan.dao.CoDaoImp;
import com.system.loan.dao.UserDaoImp;
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
		CoDaoImp co=new CoDaoImp();
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
		CoDaoImp co=new CoDaoImp();
		pagingDto paging=new pagingDto();
		paging.setPageNo(pno);
		paging.setPcnt(1);
		String filter=" limit 0,5";
		model.put("listCo", co.listCo(paging));
		model.put("paging",paging);
		return "customer_officer";		
		
	}
	
	@RequestMapping(value="/listCo",method=RequestMethod.GET)
	public String listCo(WebRequest webrequest,Map<String,Object> model){
		
		System.out.println(" test your");
		
		String pno=webrequest.getParameter("page_no");
		String pcnt=webrequest.getParameter("pcnt");
		String sw=webrequest.getParameter("sw");
		int totRec=0;
		int totPage=0;
		
		int intpno=0;
		int intpcnt=5;
		if(pno!=null){
			intpno=Integer.parseInt(pno);
		}
		if(pcnt!=null){
			intpcnt=Integer.parseInt(pcnt);
		}
		if(sw==null){
			sw="";
		}
		
		CoDaoImp co=new CoDaoImp();
		pagingDto paging=new pagingDto();
		paging.setPageNo(intpno);
		paging.setPcnt(intpcnt);
		paging.setSw(sw);
		totRec=co.totalRecord(paging);
		totPage=(int) Math.ceil((float)totRec/intpcnt);
		paging.setTotal(totRec);
		paging.setTotalPage(totPage);
		model.put("listCo", co.listCo(paging));
		model.put("paging",paging);	
		return "customer_officer";
	}
	
	@RequestMapping(value="/testjoin",method=RequestMethod.GET)
	public String test(){
		CoDaoImp co=new CoDaoImp();
		co.testjoin();
		System.out.println("how are you?");
		return null;
	}

}
