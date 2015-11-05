var CO_ID;
var CU_ID;
var AC_ID;
var TR_ID;
var TR_TYPE ;
$(document).ready(function(){

	 var tr_id = document.getElementById('tr_id').value;
	 var cu_id = document.getElementById('cu_id').value;
	// alert("wtf tr_id:="+tr_id+"==cu_id:=="+cu_id);
	 
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
			
			var customer_info='<tr>';
			customer_info+='<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Customer Officer Info (CO Info)</h4></td>';
				customer_info+='</tr>';
				customer_info+='<tr>'; 
					customer_info+='<td>Name : <span class="label label-primary">'+dat.co_first_nm+' '+dat.co_last_nm+'</span></td>';
					customer_info+='<td>Sex : <span class="label label-primary">'+dat.co_sex+'</span></td>';
					customer_info+='<td>Phone : <span class="label label-primary">'+dat.co_phone+'</span></td>';
					customer_info+='<td>National ID: <span class="label label-primary">'+dat.gu_national_id+'</span></td>	';								
				customer_info+='</tr>';
			customer_info+='<tr>';
			customer_info+='<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Customer Infomation</h4></td>';
				customer_info+='</tr>';
				customer_info+='<tr>';
					customer_info+='<td>Name : <span class="label label-primary">'+dat.cu_nm+'</span></td>';
					customer_info+='<td>Sex : <span class="label label-primary">'+dat.cu_sex+'</span></td>';
					customer_info+='<td>Phone : <span class="label label-primary">'+dat.cu_phone+'</span></td>';
					customer_info+='<td>National ID: <span class="label label-primary">'+dat.cu_national_id+'</span></td>	';								
				customer_info+='</tr>';

				customer_info+='<tr>';
					customer_info+='<td colspan="4" style="text-align:center;background-color:#FFF;"><h4>Loan Information</h4></td>';
				customer_info+='</tr>';
				customer_info+='<tr>';
					customer_info+='<td>Pay Type : <span class="label label-primary" name="">'+dat.ac_period_type+'</span></td>';
					customer_info+='<td>Total : <span class="label label-primary">'+dat.ac_amount+' R</span></td>';
					customer_info+='<td>Date : <span class="label label-primary">'+dat.pay_date+'</span></td>',
					customer_info+='<td>Transaction Amount<br/>';
						customer_info+='&nbsp;- Pay Amount : <span class="label label-primary">'+dat.tr_pay_amount+'R</span><br/>';
						customer_info+='&nbsp;- Balance : <span class="label label-primary">'+dat.tr_balance+'R</span>';
					customer_info+='</td>';									
					customer_info+='</tr>';
				customer_info+='<tr>';
					customer_info+='<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">'+dat.cu_pawn+'</span></td>';
				customer_info+='</tr>';
				customer_info+='<tr>';
					customer_info+='<td colspan="4" style="text-align:center;background-color:#FFF"><h4>Guarantor</h4></td>';
				customer_info+='</tr>';
				customer_info+='<tr>';
					customer_info+='<td>Name : <span class="label label-primary">'+dat.gu_nm+'</span></td>';
					customer_info+='<td>Sex : <span class="label label-primary">'+dat.gu_sex+'</span></td>';
					customer_info+='<td>Phone : <span class="label label-primary">'+dat.gu_phone+'</span></td>';
					customer_info+='<td>National ID: <span class="label label-primary">'+dat.gu_national_id+'</span></td>';									
				customer_info+='</tr>';
				customer_info+='<tr>								<tr>';
					customer_info+='<td colspan="4" style="border:0px;">Pawn: <span class="label label-primary">'+dat.gu_pawn+'</span></td>';
				customer_info+='</tr>';
			$("#customer_info").append(customer_info);
		}
	 });
	 
	 
	 $("#btnApprovale").click(function(){ 
		LoanApprove(); 
		 
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