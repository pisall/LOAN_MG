var CO_ID;
var CU_ID;
var AC_ID;
var TR_ID;
var TR_TYPE ;
$(document).ready(function(){

	 var tr_id = document.getElementById('tr_id').value;
	 var cu_id = document.getElementById('cu_id').value;
	// alert("wtf tr_id:="+tr_id+"==cu_id:=="+cu_id);
	 
	 // validation 
	 
	 $("#form_approve").validate({
			 errorPlacement: function(label, element) {
		           label.addClass('arrow');
		           label.insertAfter(element);
				  },
			  submitHandler: function(form) { 
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
			CO_ID=dat.co_id;
			CU_ID=dat.cu_id;
			AC_ID= dat.ac_id;
			TR_ID=dat.tr_id;
			
			var co_info="<tr><td>"+dat.co_first_nm+' '+dat.co_last_nm+"</td><td>"+dat.co_phone+"</td><td>"+dat.co_national_id+"</td></tr>";
			var cu_info="<tr><td>"+dat.cu_nm+"</td><td>"+dat.cu_phone+"</td><td>"+dat.cu_national_id+"</td></tr>";
			var gu_info="<tr><td>"+dat.gu_nm+"</td><td>"+dat.gu_phone+"</td><td>"+dat.gu_national_id+"</td></tr>";
			
			$("#co_info").append(co_info);$("#cu_info").append(cu_info);$("#gu_info").append(gu_info);
			
		}
	 });
	 
	 
	 $("#btnApprovale").click(function(){ 
		 $("#form_approve").submit();
	 });
});

// insert loanApprove Info 
function LoanApprove(){
	
	var PAID_AMOUNT = document.getElementById('paid_amount').value;
	var AMOUNT_FINE = document.getElementById('amount_fine').value ;
	var TRAN_TYPE = document.getElementById('tr_type').value; 
	var TRAN_NOTE = document.getElementById('tr_note').value;
	var TR_TYPE = document.getElementById('tr_type').value;  
	var input={co_id:CO_ID,cu_id:CU_ID,ac_id:AC_ID,tr_id:TR_ID,paid_amount:PAID_AMOUNT,tr_type:TR_TYPE,amount_fine:AMOUNT_FINE,approve_note:TRAN_NOTE}
	
	$.ajax({
		url:BASE_URL+'/loan/loanApprove/'+TR_ID+"/"+TRAN_TYPE,
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