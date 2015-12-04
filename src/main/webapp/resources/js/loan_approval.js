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
$(document).ready(function(){

	 var tr_id = document.getElementById('tr_id').value;
	 var cu_id = document.getElementById('cu_id').value;
	
	 $("#tr_type").change(function(){		
		 if($(this).val()==4){
			 TOTAL_AMOUNT=parseInt((TOTAL_PAId_AMOUNT+BALANCE));		 				 			
		 }else{
			 TOTAL_AMOUNT=TOTAL_PAId_AMOUNT;			
		 }
		 $("#paid_amount").val(accounting.formatMoney(TOTAL_AMOUNT,""));
		
	 });
	 	
	 // validation 
	 
	 $("#form_approve").validate({
			 errorPlacement: function(label, element) {
		           label.addClass('arrow');
		           label.insertAfter(element);
				  },
			  submitHandler: function(form) { 
				  $("#btnApprovale").hide();
				  window.print();
				  LoanApprove(); 				 
			  }
		});
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
			console.log(dat);
			var date_now=moment().format('DD-MM-YYYY');
			CO_ID=dat.co_id;
			CU_ID=dat.cu_id;
			AC_ID= dat.ac_id;
			TR_ID=dat.tr_id;
			
			
			var co_info="<tr><td>"+dat.co_first_nm+' '+dat.co_last_nm+"</td><td>"+dat.co_phone+"</td><td>"+dat.co_national_id+"</td></tr>";
			var cu_info="<tr><td>"+dat.cu_nm+"</td><td>"+dat.cu_phone+"</td><td>"+dat.cu_national_id+"</td></tr>";
			var gu_info="<tr><td>"+dat.gu_nm+"</td><td>"+dat.gu_phone+"</td><td>"+dat.gu_national_id+"</td></tr>";
			var loan_info="<tr><td>"+dat.ac_period_type+"</td><td>"+accounting.formatMoney(dat.ac_amount," ")+" R"+"</td><td>"+date_now+"</td><td>"+accounting.formatMoney(dat.tr_pay_amount," ")+" R"+"</td><td>"+accounting.formatMoney(dat.tr_balance,"")+" R"+"</td><td>"+dat.gu_pawn+"</td></tr>";
			$("#cu_name").html(dat.cu_nm);
			$("#admin_app_date").html(date_now);
			$("#client_app_date").html(date_now);
			
			var total_days_late=0;
			DAYS_LATE=parseInt(dat.day_late);
			var d=new Date();
			var dayOfMonth=parseInt(daysInMonth(d.getMonth(),d.getFullYear()));
			var total_tr=parseInt(dat.total_tr);			
			// CALCULATE AMOUNT
			LATE_AMOUNT=parseInt($("#total").val());
			PAID_AMOUNT=parseInt(dat.tr_pay_amount);
			BALANCE=parseInt(dat.tr_balance);
			
			if(LATE_AMOUNT!=0){
				TOTAL_PAId_AMOUNT=(LATE_AMOUNT+ PAID_AMOUNT);						
			}else if(TOTAL_PAId_AMOUNT==0){
				TOTAL_PAId_AMOUNT=PAID_AMOUNT; 			
			}
			$("#paid_amount").val(accounting.formatMoney(TOTAL_PAId_AMOUNT,""));	
						
			if(DAYS_LATE>0){		
				if($("#PERIOD_TYPE").val()=="Day"){	
					total_days_late=(parseInt(Math.floor(DAYS_LATE/4)));
				}
				if($("#PERIOD_TYPE").val()=="Week" || $("#PERIOD_TYPE").val()=="Month"){	
					total_days_late=(parseInt(DAYS_LATE)-total_tr);				
				}
				$("#day_late").val(total_days_late);
							
				AMOUNT_FINE=(TOTAL_PAId_AMOUNT * AMOUNT_RATE);
				
				console.log(AMOUNT_FINE +"=== total paid amount==" + TOTAL_PAId_AMOUNT );
			}		
				
			$("#co_info").append(co_info);$("#cu_info").append(cu_info);$("#gu_info").append(gu_info);$("#loan_info").append(loan_info);
			
		} 
	 });
	 
	 
	 $("#btnApprovale").click(function(){ 
		
		 $("#form_approve").submit();
	 });
});

function daysInMonth(month, year) {
    return new Date(year, month, 0).getDate();
}

// insert loanApprove Info 
function LoanApprove(){ 
	var PAID_AMOUNT = accounting.unformat(document.getElementById('paid_amount').value);
	var AMOUNT_FINE = document.getElementById('amount_fine').value ;
	var TRAN_TYPE = document.getElementById('tr_type').value; 
	var TRAN_NOTE = document.getElementById('tr_note').value;
	var TR_TYPE = document.getElementById('tr_type').value;  
	var TR_CU_ID=CU_ID;
	console.log(TR_CU_ID);
	var input={co_id:CO_ID,cu_id:CU_ID,ac_id:AC_ID,tr_id:TR_ID,paid_amount:PAID_AMOUNT,tr_type:TR_TYPE,amount_fine:AMOUNT_FINE,approve_note:TRAN_NOTE}
	
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
			window.location.href=BASE_URL+"/LoanAgreement/report/"+CU_ID;
		}
	}); 
}   