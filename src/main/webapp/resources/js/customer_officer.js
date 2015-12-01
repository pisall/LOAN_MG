/**
 * 
 */
var coID = $.trim(id);
$(function() {
	listCoByBrand();
	$("#test").click(function() {
		listCo();
	});
	$("#test2").click(function() {
		listCo2();
	});
	
	$("#co_info").change(function() {
		parent.coID = $.trim($(this).val());	
		parent.listCus(1);
	});

});

function listCo(pageNo) {
	var input = {
		paging : {
			pageNo : 2,
			pcnt : 3,
			total : 0,
			totalPage : 10
		}
	};
	$.ajax({
		url : BASE_URL + "/cocontroller/list_co_r001",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			alert("yest");
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

function listCo2(pageNo) {

	$.ajax({
		url : BASE_URL + "/cocontroller/list_co_r002",
		type : 'POST',
		dataType : 'JSON',
		// data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

function listCoByBrand() {
	var result="";
	$.ajax({
		url : BASE_URL + "/customer_officer/list_co",
		type : 'POST',
		dataType : 'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
			$(data).each(
					function(i, v) {
						var selected = "";
						if (v.coID == coID) {
							selected = "selected";
						}
						result += "<option value='" + v.coID + "'" + selected
								+ ">CO ID : " + v.coID + " , CO Name : "
								+ v.coFirstName+" "+v.coLastName + " </option>";
					});
			$("#co_info").append(result);
			$("#co_info_report").append(result);
			
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}