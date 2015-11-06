var page_no = 1;
var value = {};
var totalPage = 1;
var coID = $.trim(id);
var word = "";

$(function() {
	datetimenow();
	clearWord();
	listCus(page_no);
	
	console.log(encodeURIComponent("11111"));

	$("#record_num").change(function() {
		listCus(1);
	});

	$("#register").click(function() {
		addCustomer();
	});

	$("#word").keyup(function() {
		word = $(this).val();
		listCus(1);

	});

});

function loadPaging() {
	$("#paging").children("[name=p_index]").click(function() {

		page_no = $(this).children("a").html();

		listCus(page_no);
	});
}

function clearWord() {
	$("#word").val("");
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
		listCus(page_no);

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

		listCus(page_no);

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

/**
 * List Customer
 * 
 * @param pageNo
 */
function listCus(pageNo) {
	console.log(coID);
	var input = {
		"pageNo" : $.trim(pageNo),
		"pcnt" : $.trim($("#record_num").val()),
		"sw" : $.trim(word),
	}
	$
			.ajax({

				url : BASE_URL + "/customer/listCus?coID=" + coID,
				type : 'POST',
				dataType : 'JSON',
				data : JSON.stringify(input),
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {

					value = data;
					var result = "";
					var paging = data.PAGING;
					var curPage = paging.pageNo;
					totalPage = parseInt(paging.totalPage);
					
					// clear paging
					$("#paging").html("");

					showPaging(totalPage, curPage)

					if (data.REC.length > 0) {

						for (var i = 0; i < data.REC.length; i++) {
							var cuID = data.REC[i].cuID;
							result += "<tr><td>"
									+ cuID
									+ "</td>"
									+ "<td style='cursor: pointer;' class='name'>"
									+ data.REC[i].cuName
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuNickName
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuSex
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuPhone
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuAddress
									+ "</td>"
									+ "<td>"
									+ "<a href='"
									+ BASE_URL
									+ "/customer/edit_customer?cuID="
									+ cuID
									+ "'><span class='glyphicon glyphicon-pencil'></span></a>"
									+ "&nbsp;"
									+ "<a href='#none' onclick=\"return deleteCustomer("
									+ cuID
									+ ")\"><span class='glyphicon glyphicon-trash'></span></a>"
									+ "&nbsp;"
									+ "<a href='#none'><span class='glyphicon glyphicon-random' onclick=\"return getCustomerTransaction("
									+ cuID + ")\"></span></a>" + "</td></tr>";
						}

					}

					$("#tableCustomer").html(result);

					$('.name').click(function() {
						var cuID = $(this).parent().find("td:first").text();
						getCustomerDetail(cuID);
					});

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
			console.log(data);
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
				"cuDelYn" : $.trim("Y")
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
					var totalPage=value.PAGING.totalPage;
					var curPage=value.PAGING.pageNo;
					console.log("delte======="+totalPage+"cur="+curPage);
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
 * Add Customer
 */
function addCustomer() {

	var input = {
		cuName : $.trim($("#cu_name").val()),
		cuNickName : $.trim($("#cu_nick_name").val()),
		cuSex : $.trim($("#cu_sex").val()),
		cuDOB : $.trim($("#cu_dob").val()),
		cuNationalID : $.trim($("#cu_national_id").val()),
		cuPhone : $.trim($("#cu_phone").val()),
		cuAddress : $.trim($("#cu_address").val()),
		cuDtt : $.trim(datetimenow()),
		cuPawn : $.trim($("#cu_pawn").val()),
		cuNote : $.trim($("#cu_note").val()),
	}

	$.ajax({

		url : BASE_URL + "/customer/addCustomer",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {

		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

/**
 * Get Customer Transaction
 * 
 * @param cuID
 */

function getCustomerTransaction(cuID) {
	location.href = BASE_URL + "/LoanAgreement/report/" + cuID;
}

/**
 * Load Current Date Time
 * 
 * @returns
 */
function datetimenow() {
	return moment().format('YYYYMMDDhmmss');
}
