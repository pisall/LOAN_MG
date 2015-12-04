/**
 * 
 */
 
// send parametter to loanApprove
function transaction_payment(tr_id,cu_id){	
	
	var total=$("#total_amount_late").val();
	var period_type=$("#period_type").val();
	//alert(period_type);
	window.location.href=BASE_URL+"/schadule_payment/loanApprove?tr_id="+tr_id+"&cu_id="+cu_id+"&total="+total+"&period_type="+period_type+"";
	 
} 