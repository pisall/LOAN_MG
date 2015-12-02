var CO_ID;
var CU_ID;
var AC_ID;
var TR_ID;
var TR_TYPE ;
var PAID_AMOUNT=0;
var BALANCE=0;
var total_amount=0;
$(document).ready(function(){

	 var tr_id = document.getElementById('tr_id').value;
	 var cu_id = document.getElementById('cu_id').value;
	// alert("wtf tr_id:="+tr_id+"==cu_id:=="+cu_id);
	 
	 $("#tr_type").change(function(){
		 var totalAmount=0;
		 if($(this).val()==4){
			 	if($("#total").val()!=0 || $("#total").val()!="" ||$("#total").val()!=null){
					totalAmount= parseInt($("#total").val()) + parseInt(BALANCE) ;			 			 		
				}else{
					 totalAmount=parseInt(PAID_AMOUNT)+parseInt(BALANCE);
				}		
			 $("#paid_amount").val(totalAmount);
		 }else{
			 $("#paid_amount").val(total_amount);
		 }
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
			var date_now=moment().format('DD/MM/YYYY');
			CO_ID=dat.co_id;
			CU_ID=dat.cu_id;
			AC_ID= dat.ac_id;
			TR_ID=dat.tr_id;
			PAID_AMOUNT=dat.tr_pay_amount;
			BALANCE=dat.tr_balance;
			
			var co_info="<tr><td>"+dat.co_first_nm+' '+dat.co_last_nm+"</td><td>"+dat.co_phone+"</td><td>"+dat.co_national_id+"</td></tr>";
			var cu_info="<tr><td>"+dat.cu_nm+"</td><td>"+dat.cu_phone+"</td><td>"+dat.cu_national_id+"</td></tr>";
			var gu_info="<tr><td>"+dat.gu_nm+"</td><td>"+dat.gu_phone+"</td><td>"+dat.gu_national_id+"</td></tr>";
			var loan_info="<tr><td>"+dat.ac_period_type+"</td><td>"+dat.ac_amount+"</td><td>"+date_now+"</td><td>"+accounting.formatMoney(dat.tr_pay_amount," ")+" R"+"</td><td>"+accounting.formatMoney(dat.tr_balance,"")+" R"+"</td><td>"+dat.gu_pawn+"</td></tr>";
			$("#cu_name").html(dat.cu_nm);
			$("#admin_app_date").html(date_now);
			$("#client_app_date").html(date_now);
			
			if($("#total").val()!=0 || $("#total").val()!="" ||$("#total").val()!=null){
				$("#paid_amount").val($("#total").val());
				total_amount=$("#total").val();
			}else{
				$("#paid_amount").val(dat.tr_pay_amount);
				total_amount=dat.tr_pay_amount;
			}
			
			
			$("#co_info").append(co_info);$("#cu_info").append(cu_info);$("#gu_info").append(gu_info);$("#loan_info").append(loan_info);
			
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
	var TR_CU_ID=CU_ID;
	console.log(TR_CU_ID);
	var input={co_id:CO_ID,cu_id:CU_ID,ac_id:AC_ID,tr_id:TR_ID,paid_amount:PAID_AMOUNT,tr_type:TR_TYPE,amount_fine:AMOUNT_FINE,approve_note:TRAN_NOTE}
	
	$.ajax({
		url:BASE_URL+'/loan/loanApprove/'+TR_ID+"/"+TRAN_TYPE+"/"+TR_CU_ID,
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