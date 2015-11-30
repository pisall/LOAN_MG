/**
 * 
 */

$(document).ready(function(){
	//blur event
	var sw=$("#sw").val();
	listCo({pageNo:1,pcnt:10,sw:sw});
	$("#btn_search").click(function(){
		var sw=$("#sw").val();
		listCo({pageNo:1,pcnt:10,sw:sw});
	});
	
});

function listCo(input){
	
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0001",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		contentType : 'application/json; charset=utf-8',
	      dataType : 'json',
		beforeSend : function(xhr) {
			startLoading();
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			stopLoading();
			console.log(data);
			$("#list tbody").html("");
			var tbody="";
			$("#paging").html("");
			var paging=data.PAGING;
			var sw=$("#sw").val();
			if(paging.totalPage>0){
				//previous paging
				$("#paging").append('<li class="next" val="0p"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>');
				for(var i=1;i<=paging.totalPage;i++){
					$("#paging").append('<li val="'+i+'"><a href="#">'+i+'</a></li>');
				}
				//next paging
				$("#paging").append(' <li class="next" val="0n"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>');
				//add active to current page
				$("#paging").children("li[val="+paging.pageNo+"]").addClass("active");
				
				//click page index
				$("#paging").children("li").click(function(){
					listCo({pageNo:$(this).attr("val"),pcnt:10,sw:sw});
				});
				//click previous
				$("#paging").children("li[val=0p]").click(function(){
					listCo({pageNo:paging.pageNo-1,pcnt:10,sw:sw});
				});
				//click previous
				$("#paging").children("li[val=0n]").click(function(){
					listCo({pageNo:paging.pageNo+1,pcnt:10,sw:sw});
				});
				
			}
			
			$.each(data.REC,function(i,v){
				
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
						tr+='<a href="#none" name="btn_disabled" val="'+v.co_id+'"><span class="glyphicon glyphicon-trash"></span></a>';
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
			$("[name=btn_disabled]").each(function(){
				$(this).click(function(){
					var input={};
					input["co_id"]=$(this).attr("val");
					input["enabled"]=false;
					//disabledUser(input);
					
					$.confirm({
						text : "Are you sure want to disable this user?<br/>click ok to disable.",
						confirm : function() {
							disabledUser(input);

						},
						cancel : function() {
							
						}
					});
					
				});
			});
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
	
}
function disabledUser(input){
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_u0001",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			startLoading();
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			stopLoading();
			if(data.CODE=="0000"){
				var pageNo=$("#paging").children("li[class=active]").attr("val");
				listCo({pageNo:pageNo,pcnt:10});
				
			}
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


