	$(function(){
   		listCustomer();
   	}); 
   
    function listCustomer(){
		
		$.ajax({
			
			url : BASE_URL +"/customer/listCustomer",
			type : 'GET',
			dataType : 'JSON',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
				console.log(data);
				
				var result="";
				
				$(data).each(function(i,v){
					
					result+="<tr>"
								+"<td></td>"
								+"<td>Prak virak</td>"
								+"<td>Male</td>"
								+"<td>09-08-1990</td>"
								+"<td>09978797767</td>"
								+"<td>Phnom Penh</td>"
								+"<td>010 988-752</td>"										
								+"<td>"
								+"<a href='#none'><span class='glyphicon glyphicon-pencil'></span></a>"
								+"&nbsp;"
								+"<a href='#none'><span class='glyphicon glyphicon-trash'></span></a>"
								+"&nbsp;"
								+"<a href='#none'><span class='glyphicon glyphicon-random'></span></a>"
								+"</td>"		
							+"</tr>"
				});

			},
			error : function(data, status, er) {
				console.log("error: " + data + " status: " + status+ " er:" + er);
			}
		});
	}
    
 function deleteCustomer(cusID){
		
	 	var input={
	 			customerID:cusID
	 	}
		$.ajax({
			
			url : BASE_URL +"/customer/deleteCustomer",
			type : 'GET',
			dataType : 'JSON',
			data : JSON.stringify(input),
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(data) {
			
			},
			error : function(data, status, er) {
				console.log("error: " + data + " status: " + status+ " er:" + er);
			}
		});
	}
    
    