/**
 * 
 */
$(document).ready(function(){
	
	$.ajax({
		url:BASE_URL+'/Outcome/OutcomeDao',
		type:'POST',
		datatype:'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			console.log(dat);
		}
	});
});