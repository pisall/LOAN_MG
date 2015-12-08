var page_no = 1;
var value = {};
var totalPage = 1;
var coID = $.trim(id);
var total_amount=0,total_paid_amount=0,total_amount_fine=0;

$(function(){
	list_loan_late(page_no);
	
	$("#record_num").change(function() {
		list_loan_late(1);
	});
}); 


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
					var curPage = paging.pageNo;
					
					totalPage = parseInt(paging.totalPage);
					// clear paging
					$("#paging").html("");
					$("#report_loan_late").html("");
					showPaging(totalPage, curPage)
						
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
									+"<td>"+data.REC[i].cu_id+"</td>" 
									+"<td>"+data.REC[i].cu_nm+"</td>" 
									+"<td>"+data.REC[i].payment_date+"</td>" 
									+"<td>"+accounting.formatMoney(loan_amount,"")+" R"+"</td>" 
									+"<td>"+accounting.formatMoney(paid_amount,"")+" R"+"</td>" 							
									+"<td>"+accounting.formatMoney(amount_fine,"")+" R"+"</td>" 
									+"<td>"+days_late+"</td>" 
									+"<td>"+total_amount+"</td>" 
										+"</tr>";															
																					
										
							}
							$("#report_loan_late").append(result);
						}
						 
					loadPaging();

					pageNext();

					pagePrevious();
				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
}

function loadPaging() {
	$("#paging").children("[name=p_index]").click(function() {

		page_no = $(this).children("a").html();
		
		list_loan_late(page_no);
	});
}

/**
 * Next pagination
 */
function pageNext() {

	$("#p_next").click(function() {

		page_no = $(this).siblings(".active").children("a").html();
		page_no++;
		totalPage = value.PAGING.totalPage;
		if (page_no > totalPage) {
			page_no = totalPage

		}
		
		list_loan_late(page_no);

	});
}

/**
 * Previouse pagination
 */
function pagePrevious() {

	$("#p_pre").click(function() {
		page_no = $(this).siblings(".active").children("a").html();
		page_no--;
		totalPage = value.PAGING.totalPage;
		if (page_no < 1) {
			page_no = 1

		}

		list_loan_late(page_no);

	});
}
/**
 * Show pagination
 * 
 * @param totalPage
 * @param curPage
 */

function showPaging(totalPage, curPage) {

	if (totalPage > 1) {
		$("#paging")
				.append(
						'<li id="p_pre" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>');
		for (var i = 1; i <= totalPage; i++) {
			if (i == curPage)
				$("#paging").append(
						'<li class="active"  name="p_index"><a href="#none">'
								+ i + '</a></li>');

			else
				$("#paging").append(
						'<li  name="p_index"><a href="#none">' + i
								+ '</a></li>');

		}
		$("#paging")
				.append(
						'<li id="p_next" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>');
	}
}