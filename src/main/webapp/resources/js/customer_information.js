var page_no = 1;
var value = {};
var totalPage = 1;
var coID = id;
var recNum=10;

$(function() {
	
	datetimenow();
	listCus(page_no);

	$("#record_num").change(function() {
		listCus(page_no);
	});

	$("#register").click(function() {

		addCustomer();

	});

	$("#co_info").change(function() {
		coID = $.trim($(this).val());
		listCus(page_no);
	});

	$("#word").keyup(function() {
		listCus(page_no, $(this).val());
	});

});

function recordNum(){
	var result="";
	var num=0;
	var str="";
	$("#select_num").html("");
	str="<select class='form-control' id='record_num' style='width: 100%'>";
	for(var i=1;i<=5;i++){
		num=i*10;
		str+="<option value='"+num+"'>"+num+"</option>";
	}
	str+="</select>";
	$("#select_num").html(str);
}

function loadPaging() {
	$("#paging").children("[name=p_index]").click(function() {

		page_no = $(this).children("a").html();

		listCus(page_no);
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
	$("#paging").html("");
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
function listCus(pageNo, word) {
	
	var input = {
		"pageNo" : $.trim(pageNo),
		"pcnt" : $.trim($("#record_num").val()),
		"sw" : $.trim(word),
	}
	$
			.ajax({

				url : BASE_URL + "/customer/listCus/" + coID + "/" + brand,
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

					// loadTotalPage(totalPage, curPage)

					if (data.REC.length > 0) {

						for (var i = 0; i < data.REC.length; i++) {
							result += "<tr>" + "<td>"
									+ data.REC[i].cuID
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuName
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuSex
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuDOB
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuNationalID
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuAddress
									+ "</td>"
									+ "<td>"
									+ data.REC[i].cuPhone
									+ "</td>"
									+ "<td>"
									+ "<a href='"
									+ BASE_URL
									+ "/customer/customer_form_update?cuID="
									+ data.REC[i].cuID
									+ "' ><span class='glyphicon glyphicon-pencil'></span></a>"
									+ "&nbsp;"
									+ "<a href='#none' onclick=\"return deleteCustomer("
									+ data.REC[i].cuID
									+ ")\"><span class='glyphicon glyphicon-trash'></span></a>"
									+ "&nbsp;"
									+ "<a href='#none'><span class='glyphicon glyphicon-random'></span></a>"
									+ "</td>" + "</tr>"
						}

					}
					if (data.CO.length > 0) {
						listCO(data);
					}
					
					$("#tableCustomer").html(result);
					
					$("#record_num").change(function() {
						recNum=$("#record_num").val();
						listCus(page_no);
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

function listCO(data) {
	var result = "";
	$(data.CO).each(
			function(i, v) {
				var selected = "";
				if (v.coID == coID) {
					selected = "selected";
				}
				result += "<option value='" + v.coID + "'" + selected
						+ ">CO ID : " + v.coID + " , CO Name : " + v.coName
						+ " </option>";
			});
	$("#co_info").html(result);
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
				cuID : $.trim(cusID)
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
 * Load Current Date Time
 * 
 * @returns
 */
function datetimenow() {
	return moment().format('YYYYMMDDhmmss');
}
