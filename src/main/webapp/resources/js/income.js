/**
 * 
 */
$(document).ready(function(){
	
	$.ajax({
		url:BASE_URL+'/Income/IncomeDao',
		type:'POST',
		datatype:'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			for(var i=0;i<dat.length;i++){  
				 
			}
		}
	});
});