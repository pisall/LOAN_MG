var page_no = 1;
var value = {};
var totalPage = 1;
var coID = $.trim(id);
var word = "";
var tr_type="";
var startDate="";
var endDate="";


$(function() {
	datetimenow();
	clearWord();
	listCus(1);
	
	$("#paging").pagination({
		items: 100,
		itemsOnPage:10,
		cssStyle: 'light-theme',
		edges:3,
		displayedPages:3,
		currentPage:1,
		onPageClick:pageingClick
	});

	$("#from").change(function(){
		if($(this).val()==""){
			$("#to").prop('disabled', true);
		}else{
			$("#to").prop('disabled', false);
		}
	});
	
	$("#btnAdSearch").click(function(){
		if($(this).val()==1){
			$(this).html("Hide Advance Search");
			$("#advance_search").show();				
			$(this).val(0);
			
		}else if($(this).val()==0){
			tr_type=1;
			startDate="";
			endDate="";
			$(this).html("Show Advance Search");
			$("#advance_search").hide();
			$("#from,#to").val("");
			$("#to").prop('disabled', true);
			$('#tr_type option:eq(0)').prop('selected', true)
			$(this).val(1);
			listCus(1);
		}
	});

	$("#record_num").change(function() {
		$("#paging").pagination('updateItemsOnPage', $(this).val());
		listCus(1);
	});

	$("#register").click(function() {
		addCustomer();
	});

	$("#word").keyup(function() {
		word = $(this).val();
		listCus(1);

	});
	$("#tr_type").change(function() {
		tr_type = $(this).val();
		listCus(1);

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
	        listCus(1);
	      }
	    });

});

function pageingClick(pageN,event){
	listCus(pageN);
}

function dateFormate(date){
 return moment(date, "DD-MM-YYYY").format("YYYY-MM-DD")
}

function clearWord() {
	$("#word").val("");
}


/**
 * List Customer
 * 
 * @param pageNo
 */
function listCus(pageNo) {
	var input = {
		"pageNo" : $.trim(pageNo),
		"pcnt" : $.trim($("#record_num").val()),
		"sw" : $.trim(word),
		"tr_type":$.trim(tr_type),
		"startDate":$.trim(startDate),
		"endDate":$.trim(endDate)		
	}
	$
			.ajax({
				url : BASE_URL + "/customer/listCus?coID=" + coID,
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(input),
				beforeSend : function(xhr) {
					if(word=="" || word==null)startLoading();
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {					
					stopLoading();
					value = data;
					var result = "";
					var paging = data.PAGING;
					startDate="";endDate="";
					// clear paging
					$("#paging").html("");

					$("#paging").pagination('updateItems', paging.total);

					if (data.REC.length > 0) {

						for (var i = 0; i < data.REC.length; i++) {
							var cuID = data.REC[i].cu_id;
							result += "<tr><td align='center'>"
									+ cuID
									+ "</td>"
									+ "<td style='cursor: pointer;' class='name'>"
									+ "<span class='ellipsis' title='"+data.REC[i].cu_nm+"'>"+data.REC[i].cu_nm+"</span>"
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cu_national_id
									+ "</td>"
									+ "<td align='center'>"
									+ data.REC[i].cu_sex
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cu_phone
									+ "</td>"
									+ "<td style='max-width:0px'>"
									+ "<span class='ellipsis' title='"+data.REC[i].cu_address+"'>"+data.REC[i].cu_address+"</span>"
									+ "</td>"
									+ "<td align='center' class='action'>";
							
							result	+= "<a href='"+ BASE_URL+"/customer/edit_customer?cuID="+cuID+"'><span class='glyphicon glyphicon-pencil'></span></a>&nbsp;";
							if(_role == "ROLE_ADMIN"){
								result	+="<a href='#none' onclick=\"return deleteCustomer("+cuID+")\"><span class='glyphicon glyphicon-trash'></span></a>&nbsp;";
							};
							result	+="<a href='#none'><span class='glyphicon glyphicon-random' onclick=\"return getCustomerTransaction("+cuID+")\"></span></a></td></tr>";
						}

					}

					$("#tableCustomer").html(result);

					$('.name').click(function() {
						var cuID = $(this).parent().find("td:first").text();
						getCustomerDetail(cuID);
					});				
				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
}

function getCustomerDetail(cuID) {
	$.ajax({
		url : BASE_URL + "/customer/get_customer_detail/" + cuID,
		type : 'POST',
		dataType : 'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			
			$('#myModal').modal('show');
			$("#cu_id").html(data.cuID);
			$("#cu_name").html(data.cuName);
			$("#cu_nick_name").html(data.cuNickName);
			$("#cu_national_id").html(data.cuNationalID);
			$("#cu_dob").html(data.cuDOB);
			$("#cu_sex").html(data.cuSex);
			$("#cu_address").html(data.cuAddress);
			$("#cu_phone").html(data.cuPhone);
			$("#cu_note").html(data.cuNote);
			$("#cu_pawn").html(data.cuPawn);
			$("#cu_date_created").html(
					moment(data.cuDtt, "YYYYMMDD hh:mm:ss").format(
							"DD-MM-YYYY hh:mm:ss"));
			//console.log(moment(data.cuDtt, "YYYYMMDD hh:mm:ss").format("YYYY"));

		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

/**
 * Delete customer
 * 
 * @param cusID
 */

function deleteCustomer(cusID) {
	$.confirm({
		text : "Are you sure you want to delete this record?",
		confirm : function() {
			var input = {
				"cuID" : $.trim(cusID),
				"cuDelYn" : $.trim("N")
			}
			$.ajax({
				url : BASE_URL + "/customer/deleteCustomer",
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(input),
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {
					clearWord();
					word="";
					listCus(page_no);
				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});

		},
		cancel : function() {

		}
	});

}
/**
 * Get Customer Transaction
 * 
 * @param cuID
 */

function getCustomerTransaction(cuID) {	
	   popup(BASE_URL+"/LoanAgreement/report/"+cuID);
}

/**
 * Load Current Date Time
 * 
 * @returns
 */
function datetimenow() {
	return moment().format('YYYYMMDDhmmss');
}
