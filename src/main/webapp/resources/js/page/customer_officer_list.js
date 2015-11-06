/**
 * 
 */

$(document).ready(function(){
	//blur event
	listCo();
	
});

function listCo(){
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0001",
		type : 'POST',
		dataType : 'JSON',
		//data : JSON.stringify(input),
		contentType : 'application/json; charset=utf-8',
	      dataType : 'json',
		/*beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},*/
		success : function(data) {
			var tbody="";
			$.each(data,function(i,v){
				var tr="";
				tr+='<tr>';
					tr+='<td name="co_id">'+v.co_id+'</td>';
					tr+='<td>'+v.co_first_nm+' '+v.co_last_nm+'</td>';
					tr+='<td>'+v.co_sex+'</td>';
					tr+='<td>'+v.co_brand+'</td>';
					tr+='<td>'+v.co_phone+'</td>';
					tr+='<td>';
						tr+='<a href="'+BASE_URL + '/co_001_controller/co_0004/'+v.co_id+'"><span class="glyphicon glyphicon-pencil"></span></a>';
						tr+='&nbsp;';
						tr+='<a href="#none"><span class="glyphicon glyphicon-trash"></span></a>';
					tr+='</td>';
				tr+='</tr>';
				tbody+=tr;
				
			});
			$("#list tbody").append(tbody);
			
			$("#list tbody").children("tr").each(function(){
				$(this).children("td[name=co_id]").click(function(){
					//alert($(this).text());
					viewCustomer($(this).text());
					
					
				});
			});
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
	
}
function viewCustomer(id){
	var input={};
	input["co_id"]=id;
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0002",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
			$("#pop_co_id").html(data.co_id);
			$("#pop_co_nm").html(data.co_first_nm+' '+ data.co_last_nm);
			$("#pop_co_sex").html(data.co_sex);
			$("#pop_co_national_id").html(data.co_national_id)
			$("#pop_brand").html(data.co_brand)
			$("#pop_co_phone").html(data.co_phone);
			$("#pop_office_phone").html(data.co_cpm_phone);
			$("#pop_co_pb_address").html(data.co_pb_address);
			$("#pop_co_address").html(data.address);
			$("#pop_reg_id").html(data.reg_co_first_nm+" "+ data.reg_co_last_nm);
			$("#pop_reg_dtt").html(data.reg_dtt);
			$("#pop_update_dtt").html(data.update_dtt);
			
			$("#myModal").modal("show");
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}


