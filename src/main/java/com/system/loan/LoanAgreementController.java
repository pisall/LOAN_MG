package com.system.loan;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.system.loan.dao.LoanAgreementDao;
import com.system.loan.dao.TransectionDao;
import com.system.loan.dto.AcountInfoDto;
import com.system.loan.dto.GuarantorInfoLoanerDto;
import com.system.loan.dto.LoanAgreementDto;
import com.system.loan.dto.TransectionDto; 

@Controller
@RequestMapping(value="/LoanAgreement")
public class LoanAgreementController implements Serializable{
		 
		//String username = request.getParameter("us_name"); 
		
		/**
	 * 
	 */
	
	int cus_id=0;
	
	TransectionDao tranDao = null;
	
	private static final long serialVersionUID = 1L;
		LoanAgreementDao loanAgreDao = null;
		@RequestMapping(value="/newLoanAgreement" , method=RequestMethod.GET)
		public ModelAndView newLoanAgreement(){ 
			ModelAndView mv=new ModelAndView();
			mv.setViewName("loan_agreement");
			mv.addObject("page_id","loan_agreement");
			return mv;
		}
		
		@RequestMapping(value="/newLoanAgreementGetData" , method=RequestMethod.POST)
		public String newLoanAgreement(@ModelAttribute("AcountInfoDto") AcountInfoDto acodto  , @ModelAttribute("GuarantorInfoLoanerDto") GuarantorInfoLoanerDto guiloanernfoDto,  @ModelAttribute("LoanAgreementDto")LoanAgreementDto loanAgreDto,Map<String,Object>  model){
			
			Set<TransectionDto> transections = new HashSet<TransectionDto>();
			float amount = acodto.getAc_amount();
			float rate	 = acodto.getAc_rate();
			int   period = Integer.parseInt(acodto.getAc_period());
			float saving_amount = acodto.getAc_saving_amount();
			String  pay_period_type = acodto.getAc_period_type(); 
			float principal_paid 	=	amount/period; 
			   
			
			float balance_remain 	= amount;
			float balance_payment	=0;
			float total_pay_rate 	= 0;// Tatal pay rate on schadule
			SimpleDateFormat dateformate = null;
			String pay_date_time = null ;
			String DatetimePayDay = null; 
			TransectionDto tran = null;
			
			
			// loop number of period 
		for ( int i=0;i<period; i++){   
			// calculate Date Time much i 
		    Calendar calendar = Calendar.getInstance(); 
		    Date DatePayTime=null;
		    int pay_day = 0;
		    
		    if(pay_period_type.equals("Day")){
		    	 calendar.add(Calendar.DAY_OF_MONTH, i);	
		    	 DatePayTime = calendar.getTime();
		    	 pay_day = calendar.get(Calendar.DAY_OF_WEEK);
		    }else if(pay_period_type.equals("Week")){
		    	 calendar.add(Calendar.WEEK_OF_MONTH, i);
		    	 DatePayTime = calendar.getTime();
		    	 pay_day = calendar.get(Calendar.DAY_OF_WEEK);
		    }else if(pay_period_type.equals("Month")){
		    	 calendar.add(Calendar.MONTH, i);
		    	 DatePayTime = calendar.getTime();
		    	 pay_day = calendar.get(Calendar.DAY_OF_WEEK);
		    }else if(pay_period_type.equals("Year")){
		    	 calendar.add(Calendar.YEAR, i); 
		    	 DatePayTime = calendar.getTime();
		    	 pay_day = calendar.get(Calendar.DAY_OF_WEEK);
		    }  
		    
		    //pay_date_time for pay on schedule 
		    dateformate = new SimpleDateFormat("yyyyMMddhhHHmmss");
		    pay_date_time=dateformate.format(DatePayTime); 
		    // day pay on schedule 
		    String Pay_day_Str= ""+pay_day; 
		    
		    if(Pay_day_Str.equals("1")){ 
		    		DatetimePayDay="Monday"; 
		    		
		    }else if(Pay_day_Str.equals("2")){
		    	DatetimePayDay="Monday";
		    	
		    }else if(Pay_day_Str.equals("3")){
		    	DatetimePayDay="Tuesday";
		    	
		    }else if(Pay_day_Str.equals("4")){
		    	DatetimePayDay="Wednesday";
		    	
		    }else if(Pay_day_Str.equals("5")){
		    	DatetimePayDay="Thursday";
		    	
		    }else if(Pay_day_Str.equals("6")){
		    	DatetimePayDay="Friday"; 
		    	
		    } else if(Pay_day_Str.equals("7")){
		    	DatetimePayDay="Monday";
		    	 
		    } 
		    
		    // dapy payment
		    Pay_day_Str=DatetimePayDay;  
			
		   // System.out.println("Pay time ::==="+pay_date_time);
		   // System.out.println("Pay Day  ::==="+Pay_day_Str);
		    
		    //calculate 
		    balance_remain=balance_remain-principal_paid;
		    total_pay_rate=balance_remain*rate; 
			balance_payment=principal_paid+total_pay_rate; 
			
			// set data to Transection Object
			Date date = new Date (); 
			dateformate = new SimpleDateFormat("yyyyMMddhhHHmmss"); 
			String dateimte = dateformate.format(date.getTime());
			
			tran = new TransectionDto();
			
			tran.setTr_balance(balance_remain);			
			tran.setTr_origin_amount(principal_paid);	
			tran.setTr_save_payment(saving_amount);		
			tran.setTr_pay_amount(balance_payment);		
			tran.setTr_total_rate(total_pay_rate);		 
			tran.setPay_date(pay_date_time);			
			tran.setPay_day(Pay_day_Str);				
			tran.setTr_dtt(dateimte);					
			tran.setTr_stts("1");
			
			tran.setAccount(acodto);
			tran.setLoanAgreement(loanAgreDto); 
			 
			transections.add(tran); 
			acodto.setLoanAGr(loanAgreDto);
			guiloanernfoDto.setLoanAgre(loanAgreDto);
			acodto.setAc_stat("Y");
			
			// set data to cus_id
			
			
			//end loop 
			}  
		
		loanAgreDto.getGurantorInfoHash().add(guiloanernfoDto);
		loanAgreDto.getAcountInfoHash().add(acodto);
		acodto.setTransection(transections);
		
		loanAgreDao =new LoanAgreementDao();
		loanAgreDao.InsertNewCustomer(loanAgreDto); 
		
		cus_id= loanAgreDto.getCu_id(); 
		 return  "redirect:/LoanAgreement/report/"+cus_id;
		}
		  
		
		@RequestMapping(value="/report/{id}",method = RequestMethod.GET)
		public  String ShowReport(@PathVariable("id") int id, Map<String ,Object>model) {  
			 
			tranDao = new TransectionDao();
			model.put("list", tranDao.ShowReport(id));
			model.put("Customer", tranDao.Customer_Report(id));
			return "report"; 
		}  
}
