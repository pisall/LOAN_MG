/**
 * 
 */
 
// send parametter to loanApprove
function transaction_payment(tr_id,cu_id){	
	var total=$("#total_amount_late").val();
	window.location.href=BASE_URL+"/schadule_payment/loanApprove?tr_id="+tr_id+"&cu_id="+cu_id+"&total="+total+"";
	 
} 