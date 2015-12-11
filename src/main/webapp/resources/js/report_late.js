var page_no = 1;
var value = {};
var totalPage = 1;
var coID = $.trim(id);
var total_amount=0,total_paid_amount=0,total_amount_fine=0;

$(function(){
	list_loan_late(page_no);
	
	$("#paging").pagination({
		items: 100,
		itemsOnPage:10,
		cssStyle: 'light-theme',
		edges:3,
		displayedPages:3,
		currentPage:1,
		onPageClick:pageingClick
	});
	
	$("#record_num").change(function() {
		$("#paging").pagination('updateItemsOnPage', $(this).val());
		list_loan_late(1);
	});
}); 

function pageingClick(pageN,event){
	list_loan_late(pageN);
}

function list_loan_late(pageNo) {
	var input = {
		"pageNo" : $.trim(pageNo),
		"pcnt" : $.trim($("#record_num").val()),
	}
	$
			.ajax({
				url : BASE_URL + "/report/report_loan_late?coID=" + coID,
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
					value = data;
					var result = "";
					var paging = data.PAGING;

					// clear paging
					$("#paging").html("");
					$("#report_loan_late").html("");

					$("#paging").pagination('updateItems', paging.total);
					
						
						if (data.REC.length > 0) {

							for (var i = 0; i < data.REC.length; i++) {
								var value=[];
								    value = data.REC[i];
								    var amount_fine=ceilAmount(data.REC[i].amount_fine_days_weeks_late + data.REC[i].amount_fine_months_late )
								    var paid_amount=ceilAmount(data.REC[i].paid_amount);
								    var loan_amount=ceilAmount(data.REC[i].loan_amount);
								    var days_late=(data.REC[i].total_days_weeks_late + data.REC[i].total_months_late);
								    var total_amount=accounting.formatMoney((paid_amount+amount_fine),"")+" R";
														
								result += "<tr>" 
									+"<td  align='center'>"+data.REC[i].cu_id+"</td>" 
									+"<td align='left'>"+data.REC[i].cu_nm+"</td>" 
									+"<td align='center' >"+data.REC[i].payment_date+"</td>" 
									+"<td>"+accounting.formatMoney(loan_amount,"")+" R"+"</td>" 
									+"<td '>"+accounting.formatMoney(paid_amount,"")+" R"+"</td>" 							
									+"<td >"+accounting.formatMoney(amount_fine,"")+" R"+"</td>" 
									+"<td align='center'>"+days_late+"</td>" 
									+"<td >"+total_amount+"</td>" 
									+"<td  align='center'>"+data.REC[i].co_first_nm +" "+data.REC[i].co_last_nm +"</td>" 
									+"<td  align='center'>"+data.REC[i].co_phone+"</td>" 
									+"</tr>";															
																					
										
							}
							$("#report_loan_late").append(result);
						}
						 					
				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
}

