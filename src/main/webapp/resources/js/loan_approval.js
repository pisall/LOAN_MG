var CO_ID;
var CU_ID;
var AC_ID;
var TR_ID;
var TR_TYPE ;
var PAID_AMOUNT=0;
var BALANCE=0;
var LATE_AMOUNT=0;
var TOTAL_PAId_AMOUNT=0;
var TOTAL_AMOUNT=0;
var AMOUNT_FINE=0,AMOUNT_RATE=10/100,TOTAL_AMOUNT_FINE=0;
var DAYS_LATE=0;
var TOTAL_FINE_AMOUNT_LATE=0;
var PAY_AMOUNT_LATE=0;
var AMOUNT_FINE=0;
var AMOUNT_FINE_LATE=0;
var PRE_PAY=0;
var tr_id=tr_id;
var cu_id=cu_id;
var tr_stts=tr_stts;


$(document).ready(function(){	
	 getDaysLate();
	 onblur();
	 $("#paid_amount").ForceNumericOnly();
	 $("#day_late").ForceNumericOnly();
	 $("#amount_fine").ForceNumericOnly();
	 $("#pre_pay").ForceNumericOnly();
	 
	 if(tr_stts==2){
		$("#btnApprovale").html("Update");
		$("#btnApprovale").val(1);
		listEditLoanApprove();
	 }
	 
	 $("#tr_type").change(function(){	
			
		 $("#total_paid_amount").val(accounting.formatMoney(($(this).val()==4)?getTotalFinishedAmount():getTotalAmount(),""));	
		
		 if(PRE_PAY>0){
			$("#frm_pre_pay").show();
			$("#frm_balance").show();
			if($(this).val()==4){
				$("#balance").val(accounting.formatMoney(getTotalFinishedAmount() - getPrepay(),""));
			}else{
				$("#balance").val(accounting.formatMoney(accounting.formatMoney(getBalance()),""));
			}
		}else{
			if($(this).val()==5){
				$("#frm_pre_pay").show();
				$("#frm_balance").show();
			}else{
				$("#frm_pre_pay").hide();
				$("#frm_balance").hide();
				$("#pre_pay").val(0);
			}
		}
	 });
	 
	 $("#paid_amount,#amount_fine").keyup(function(){
		 $("#total_paid_amount").val(accounting.formatMoney(getTotalAmount(),""));
		 $("#balance").val(accounting.formatMoney(getBalance(),""));
	 });
	 
	 $("#day_late").keyup(function(){
		 var days_late=$(this).val(); 
		 var total=0;
		 $("#amount_fine").val((days_late>0?AMOUNT_FINE_LATE:0));
		 $("#total_paid_amount").val(accounting.formatMoney(getTotalAmount(),""));
	 });
	 
	 $("#pre_pay").keyup(function(){
		 $("#balance").val(accounting.formatMoney(getBalance(),""));
	 });
	 	
	 // validation 
	 
	 /*$("#form_approve").validate({
			 errorPlacement: function(label, element) {
		           label.addClass('arrow');
		           label.insertAfter(element);
				  },
			  submitHandler: function(form) { 
				  $("#btnApprovale").hide();
				  window.print();
				  if($("#btnApprovale").val()==1){	
					  updateLoanApprove();
				  }else{
					  LoanApprove(); 		
				  }		 
			  }
		});*/

	 $("#btnApprovale").click(function(){ 
		
		 add_loan_approve();
		// $("#form_approve").submit();
	 });

});

function getPrepay(){
	return ceilAmount(parseInt(accounting.unformat(document.getElementById('pre_pay').value)));
}

function getBalance(){
	return ceilAmount(getTotalAmount() - parseInt(accounting.unformat(document.getElementById('pre_pay').value)));
}
	 
function getTotalFinishedAmount(){
	return ceilAmount(getTotalAmount() + parseInt(BALANCE));
}

function getTotalAmount(){
	return ceilAmount(parseInt(accounting.unformat(document.getElementById('paid_amount').value)) + parseInt(accounting.unformat(document.getElementById('amount_fine').value) ))
	
}

function listEditLoanApprove(){
	startLoading();
	$.ajax({
		url:BASE_URL+"/loan/get_edit_loan_approve/"+tr_id,
		type:'POST',
		datatype:'JSON', 
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
		
			stopLoading();
			$("#paid_amount").val(accounting.formatMoney((dat.paid_amount),""));
			$("#day_late").val(dat.days_late);
			$("#amount_fine").val(accounting.formatMoney(dat.amount_fine,""));
			$("#total_paid_amount").val(accounting.formatMoney(dat.total_paid_amount,""));
		}
	}); 
}

function listTrInfo(){
	startLoading();
	 $.ajax({
			url:BASE_URL+'/schadule_payment/schadule/'+tr_id+"/"+cu_id,
			type:'POST',
			datatype:'JSON',
			//data:{tr_id:tr_id,cu_id:cu_id},
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success:function(dat){
				console.log("information "+dat);
				stopLoading();
				var date_now=moment().format('DD-MM-YYYY');
				CO_ID=dat.co_id;
				CU_ID=dat.cu_id;
				AC_ID= dat.ac_id;
				TR_ID=dat.tr_id;
				PRE_PAY=dat.pre_pay;
				
				var co_info="<tr><td>"+dat.co_first_nm+' '+dat.co_last_nm+"</td><td>"+dat.co_phone+"</td><td>"+dat.co_national_id+"</td></tr>";
				var cu_info="<tr><td>"+dat.cu_nm+"</td><td>"+dat.cu_phone+"</td><td>"+dat.cu_national_id+"</td></tr>";
				var gu_info="<tr><td>"+dat.gu_nm+"</td><td>"+dat.gu_phone+"</td><td>"+dat.gu_national_id+"</td></tr>";
				var loan_info="<tr><td>"+dat.ac_period_type+"</td><td>"+accounting.formatMoney(dat.ac_amount," ") +"</td><td>"+date_now+"</td><td>"+accounting.formatMoney(dat.tr_pay_amount," ") +"</td><td>"+accounting.formatMoney(dat.tr_balance,"") +"</td><td>"+dat.gu_pawn+"</td></tr>";
				$("#cu_name").html(dat.cu_nm);
				$("#admin_app_date").html(date_now);
				$("#client_app_date").html(date_now);
				
					
				// CALCULATE AMOUNT
				LATE_AMOUNT=parseInt($("#total").val());
				PAID_AMOUNT=parseInt(dat.tr_pay_amount);
				BALANCE=parseInt(dat.tr_balance);
				
				if(dat.last_tr_id==tr_id){
					$("#tr_type option[value='5']").remove();
					$("#tr_type option[value='2']").remove();
				}
							
				// calculate days late 
				if(tr_stts==1){
					$("#paid_amount").val(accounting.formatMoney(ceilAmount(PAID_AMOUNT+PAY_AMOUNT_LATE),"")  );
					$("#day_late").val((DAYS_LATE>0)?DAYS_LATE:0);
					$("#amount_fine").val(accounting.formatMoney(((AMOUNT_FINE_LATE >0)?ceilAmount(AMOUNT_FINE_LATE):0),"") );
					$("#total_paid_amount").val(accounting.formatMoney((TOTAL_FINE_AMOUNT_LATE +PAID_AMOUNT)>0?(ceilAmount(TOTAL_FINE_AMOUNT_LATE +PAID_AMOUNT)):ceilAmount(PAID_AMOUNT+PAY_AMOUNT_LATE),"") );
					if(PRE_PAY>0){
						$("#btnApprovale").val(1);
						$("#tr_type option[value='5']").remove();
						$("#pre_pay").attr("disabled","disabled");
						$("#frm_pre_pay").show();
						$("#frm_balance").show();
						$("#pre_pay").val(accounting.formatMoney(ceilAmount(PRE_PAY),""));
						$("#balance").val(accounting.formatMoney(getBalance(),""));
					}
				}		

							
				if(tr_stts==3){
		
					$("#paid_amount").val(accounting.formatMoney(ceilAmount(PAY_AMOUNT_LATE),"") );
					$("#day_late").val((DAYS_LATE>0)?DAYS_LATE:0);					
					$("#amount_fine").val(accounting.formatMoney(((AMOUNT_FINE_LATE >0)?ceilAmount(AMOUNT_FINE_LATE):0),"") );							
					$("#total_paid_amount").val(accounting.formatMoney(((TOTAL_FINE_AMOUNT_LATE >0)?ceilAmount(TOTAL_FINE_AMOUNT_LATE):ceilAmount(PAY_AMOUNT_LATE)),"") );
				}
				
				$("#co_info").append(co_info);$("#cu_info").append(cu_info);$("#gu_info").append(gu_info);$("#loan_info").append(loan_info);
				
			} 
		 });
}

function updateLoanApprove(){
	var TOTAL_PAID_AMOUNT=accounting.unformat(document.getElementById('total_paid_amount').value);
	var PAID_AMOUNT = accounting.unformat(document.getElementById('paid_amount').value);
	var TOTAL_AMOUNT_FINE = accounting.unformat(document.getElementById('amount_fine').value) ;
	var TOTAL_DAYS_LATE=document.getElementById('day_late').value;
	var TOTAL_PREPAY=accounting.unformat(document.getElementById('pre_pay').value);
	var TRAN_TYPE = document.getElementById('tr_type').value; 
	var TRAN_NOTE = document.getElementById('tr_note').value;
	var TR_TYPE = document.getElementById('tr_type').value;  
	var TR_CU_ID=CU_ID;
	var input={co_id:CO_ID,cu_id:CU_ID,ac_id:AC_ID,tr_id:TR_ID,paid_amount:PAID_AMOUNT,total_paid_amount:TOTAL_PAID_AMOUNT,tr_type:TR_TYPE,amount_fine:TOTAL_AMOUNT_FINE,days_late:TOTAL_DAYS_LATE,pre_pay:TOTAL_PREPAY,approve_note:TRAN_NOTE}
	startLoading();
	$.ajax({
		url:BASE_URL+"/loan/updateLoanApprove/"+TR_ID+"/"+TRAN_TYPE+"/"+TR_CU_ID,
		type:'POST',
		datatype:'JSON', 
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){		
			stopLoading();
			window.location.href=BASE_URL+"/LoanAgreement/report/"+CU_ID;
		}
	}); 
}


function daysInMonth(month, year) {
    return new Date(year, month, 0).getDate();
}

function onblur(){
	//Customer validation 
	checkNullOnBlue("paid_amount");
	checkNullOnBlue("day_late");
	checkNullOnBlue("amount_fine");
	checkNullOnBlue("pre_pay");
}

function validation(input){
	/*--  log_email  --*/
	var error=false;
	if(checkNull(input.paid_amount,"paid_amount"))error=true;
	if(checkNull(input.day_late,"day_late"))error=true;
	if(checkNull(input.amount_fine,"amount_fine"))error=true;
	if(checkNull(input.pre_pay,"pre_pay"))error=true;
	return error;
}
function add_loan_approve(){
	var input={};
	input['paid_amount']=$("#paid_amount").val();
	input['day_late']=$("#day_late").val();
	input['amount_fine']=$("#amount_fine").val();
	input['pre_pay']=$("#pre_pay").val();
	
	console.log(input);
	
	if(validation(input)){
		return;
	}	

	 
	  if($("#btnApprovale").val()==1){	
		  updateLoanApprove();
	  }else{
		  LoanApprove(); 		
	  }
	  
	  window.print();
   
}

// insert loanApprove Info 
function LoanApprove(){ 
	var TOTAL_PAID_AMOUNT=accounting.unformat(document.getElementById('total_paid_amount').value);
	var PAID_AMOUNT = accounting.unformat(document.getElementById('paid_amount').value);
	var TOTAL_AMOUNT_FINE = accounting.unformat(document.getElementById('amount_fine').value) ;
	var TOTAL_DAYS_LATE=accounting.unformat(document.getElementById('day_late').value);
	var TOTAL_PREPAY=accounting.unformat(document.getElementById('pre_pay').value);
	var TRAN_TYPE = document.getElementById('tr_type').value; 
	var TRAN_NOTE = document.getElementById('tr_note').value;
	var TR_TYPE = document.getElementById('tr_type').value;  
	var TR_CU_ID=CU_ID;
	
	var input={co_id:CO_ID,cu_id:CU_ID,ac_id:AC_ID,tr_id:TR_ID,paid_amount:PAID_AMOUNT,total_paid_amount:TOTAL_PAID_AMOUNT,tr_type:TR_TYPE,amount_fine:TOTAL_AMOUNT_FINE,days_late:TOTAL_DAYS_LATE,pre_pay:TOTAL_PREPAY,approve_note:TRAN_NOTE}
	startLoading();
	$.ajax({
		url:BASE_URL+"/loan/loanApprove/"+TR_ID+"/"+TRAN_TYPE+"/"+TR_CU_ID,
		type:'POST',
		datatype:'JSON', 
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			
			stopLoading();
			window.location.href=BASE_URL+"/LoanAgreement/report/"+CU_ID;
			//parent.listCus(1);
		}
	}); 
}   

//insert loanApprove Info 
function getDaysLate(){ 
	startLoading();
	$.ajax({
		url:BASE_URL+"/loan/calculate_days_late/"+cu_id,
		type:'POST',
		datatype:'JSON', 
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			stopLoading();
			$(dat).each(function(i,v){
				if(dat[i].ac_period_type=="Month"){
					PAY_AMOUNT_LATE+=parseInt(dat[i].tr_pay_amount);
					DAYS_LATE=(parseInt(dat[0].total_months_late));
					AMOUNT_FINE_LATE+=(parseInt(dat[i].amount_fine_months_late))
				}else if(dat[0].ac_period_type=="Day" || dat[0].ac_period_type=="Week"){				
					PAY_AMOUNT_LATE+=parseInt(dat[i].tr_pay_amount);
					DAYS_LATE=(parseInt(dat[0].total_days_weeks_late));
					AMOUNT_FINE_LATE+=(parseInt(dat[i].amount_fine_days_weeks_late))							
				}	
			});
			TOTAL_FINE_AMOUNT_LATE+=parseInt(PAY_AMOUNT_LATE + AMOUNT_FINE_LATE);
			 listTrInfo();
		}
	}); 
}   