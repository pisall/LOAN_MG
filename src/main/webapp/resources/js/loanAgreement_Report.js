/**
 * generate report
 */


$(document).ready(function(){
//	loanReport();
});

function loanReport(){
	$.ajax({
		url:BASE_URL+"/LoanAgreement/report",
		type:'POST',
		dataType:'JSON',
		//data:JSON.stringify(input),
		
		beforeSend: function(xhr){
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		}, 
		succcess:function(dat){
			  console.log(">>>>>> loan "+dat);
		}
	});
}