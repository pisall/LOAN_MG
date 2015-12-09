var page_no = 1;
var value = {};
var totalPage = 1;
var coID = $.trim(id);
var word = "";
var tr_type="";
var startDate="";
var endDate="";
var total_amount=0,total_paid_amount=0,total_amount_fine=0;

$(function(){
	list_expend_report(page_no);
	$("#record_num").change(function() {
		list_expend_report(1);
	});
	$("#co_info_report").change(function() {
		coID = $.trim($(this).val());	
		list_expend_report(1);
		$("#from,#to").val("");
		$("#to").prop('disabled', true);
	});
	
	$("#from").change(function(){
		if($(this).val()==""){
			$("#to").prop('disabled', true);
		}else{
			$("#to").prop('disabled', false);
		}
	});
	
	$( "#from" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths:1,
	      dateFormat: 'dd-mm-yy',
	      onClose: function( selectedDate ) {
	        $( "#to" ).datepicker( "option", "minDate", selectedDate );
	      }
	    });
	    $( "#to" ).datepicker({
	      defaultDate: "+1w",
	      changeMonth: true,
	      numberOfMonths: 1,
	      dateFormat: 'dd-mm-yy',
	      onClose: function( selectedDate ) {
	    	  if($("#from").val()!="" && $("#to").val()!=""){
	    		  startDate= dateFormate( $("#from").val()); endDate=dateFormate($("#to").val());
	    	  }
	        $( "#from" ).datepicker( "option", "maxDate", selectedDate );	      
	        list_expend_report(1);
	        //$("#from,#to").val("");
	        //$("#to").prop("disabled",true);
	      }
	    });
	
}); 

function dateFormate(date){
	 return moment(date, "DD-MM-YYYY").format("YYYY-MM-DD")
}

function list_expend_report(pageNo) {

	var input = {
		"pageNo" : $.trim(pageNo),
		"pcnt" : $.trim($("#record_num").val()),
		"startDate":$.trim(startDate),
		"endDate":$.trim(endDate)		
	}
	$
			.ajax({
				url : BASE_URL + "/report/list_expend_report?coID=" + coID,
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(input),
				beforeSend : function(xhr) {
					startLoading();
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {	
					console.log(data);
					stopLoading();		
					value = data;
					var result = "";
					var paging = data.PAGING;
					var curPage = paging.pageNo;
					
					totalPage = parseInt(paging.totalPage);
					startDate="";endDate="";
					total_amount=ceilAmount(parseInt(data.TOTAL_AMOUNT.total_amount));
					total_paid_amount=ceilAmount(parseInt(data.TOTAL_AMOUNT.total_paid_amount));
					total_amount_fine=ceilAmount(parseInt(data.TOTAL_AMOUNT.total_amount_fine));
					
					console.log(total_paid_amount);
					// clear paging
					$("#paging").html("");
					$("#loan_expend_report").html("");
					showPaging(totalPage, curPage)
				
					if (data.REC.length > 0) {

						for (var i = 0; i < data.REC.length; i++) {
							var cuID = data.REC[i].cu_id;
							
							//subAmount=data.SUB_AMOUNT;
							result += "<tr><td  align='center'>"
									+ cuID
									+ "</td>"
									+ "<td style='cursor: pointer;' class='name'>"
									+ "<span class='ellipsis' title='"+data.REC[i].cu_nm+"'>"+data.REC[i].cu_nm+"</span>"
									+ "</td>"								
									+ "<td  align='center'>" 
									+ formatStringToDateTime(data.REC[i].ac_start_date,"")
									+ "</td>"
									+ "<td>"
									+ accounting.formatMoney(data.REC[i].ac_amount," ")+" R"
									+ "</td>"
									
									+"</tr>";
						}
						$("#loan_expend_report").append(result);
						$("#loan_expend_report").append("<tr><td colspan='3' style='text-align:right;color:blue; position: relative;left: -87px;'>Total Amount :</td><td style='color:blue;'>"+accounting.formatMoney(total_amount," ")+" R</td></tr>");
						$("#loan_expend_report").append("<tr><td colspan='3' style='text-align:right;color:red; position: relative;left: -87px;'>Total Paid Amount :</td><td style='color:red;'>"+accounting.formatMoney(getTotalPaidAmount()," ")+" R</td></tr>");
						$("#loan_expend_report").append("<tr><td colspan='3' style='text-align:right;color:red; position: relative;left: -87px;'>Total Not Paid Amount :</td><td style='color:red;'>"+accounting.formatMoney(((getBalance()<=0)?0:getBalance())," ")+" R</td></tr>");
						$("#loan_expend_report").append("<tr><td colspan='3' style='text-align:right;color:red; position: relative;left: -87px;'>Profit :</td><td style='color:red;'>"+accounting.formatMoney((getProfit()>0)?getProfit():0," ")+" R</td></tr>");
						
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


function getTotalPaidAmount(){
	return (total_paid_amount + total_amount_fine)
}

function getProfit(){
	return (getTotalPaidAmount() - total_amount);
}

function getBalance(){
	return (total_amount - getTotalPaidAmount());
}

function loadPaging() {
	$("#paging").children("[name=p_index]").click(function() {

		page_no = $(this).children("a").html();

		list_expend_report(page_no);
		
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
		list_expend_report(page_no);

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

		list_expend_report(page_no);

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