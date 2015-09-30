$(function() {
	var page_no = 1;
	var value = {};
	var totalPage = 0;
	
	listCus(page_no);

	
	pageNext();

	pagePrevious();
});

function loadPaging() {
	$("#paging").children("[name=p_index]").click(function() {

		page_no = $(this).children("a").html();

		listCus(page_no);
	});
}

function pageNext() {
	$("#p_next").click(function() {
		page_no = $(this).siblings(".active").children("a").html();
		page_no++;
		totalPage = value.PAGING.totalPage;
		if (page_no > totalPage) {
			page_no = totalPage
			alert("cannot next");
		}
		listCus(page_no);

	});
}

function pagePrevious() {

	$("#p_pre").click(function() {
		page_no = $(this).siblings(".active").children("a").html();
		page_no--;
		totalPage = value.PAGING.totalPage;
		alert(page_no);
		if (page_no> totalPage) {
			page_no = totalPage
			alert("cannot previous");
		}

		listCus(page_no);
		
		console.log(page_no)

	});
}

function showPagin(active, i) {
	var previous = '<li id="p_pre" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
	var number = '<li class=' + active + '  name="p_index"><a href="#none">'
			+ i + '</a></li>';
	var next = '<li id="p_next" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
	var paging = previous + number + next;
	return paging;
}

function listCus(pageNo) {
	var input = {
		pageNo : pageNo,
		sw : ''
	}
	$
			.ajax({

				url : BASE_URL + "/customer/listCus",
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
					// clear
					$("#paging").html("");

					var totalPage = parseInt(paging.totalPage);

					for (var i = 1; i <= totalPage; i++) {
						if (i == curPage)
							$("#paging").html(showPagin('active', i));

						else
							$("#paging").html(showPagin('', i));

					}

					//loadPaging();
									
					
					$("#p_pre").click(
							function() {
								page_no = $(this).siblings(".active").children(
										"a").html();
								page_no--;
								listCus(page_no);

							});

					$(data)
							.each(
									function(i, v) {

										result += "<tr>" + "<td>"
												+ v[0]
												+ "</td>"
												+ "<td>"
												+ v[1]
												+ "</td>"
												+ "<td>"
												+ v[2]
												+ "</td>"
												+ "<td>"
												+ v[3]
												+ "</td>"
												+ "<td>"
												+ v[4]
												+ "</td>"
												+ "<td>"
												+ v[5]
												+ "</td>"
												+ "<td>"
												+ v[6]
												+ "</td>"
												+ "<td>"
												+ "<a href='#none'><span class='glyphicon glyphicon-pencil'></span></a>"
												+ "&nbsp;"
												+ "<a href='#none'><span class='glyphicon glyphicon-trash'></span></a>"
												+ "&nbsp;"
												+ "<a href='#none'><span class='glyphicon glyphicon-random'></span></a>"
												+ "</td>" + "</tr>"
									});
					$("#tableCustomer").html(result);
					
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

function listCustomer() {

	$
			.ajax({

				url : BASE_URL + "/customer/listCustomer",
				type : 'GET',
				dataType : 'JSON',
				beforeSend : function(xhr) {
					xhr.setRequestHeader("Accept", "application/json");
					xhr.setRequestHeader("Content-Type", "application/json");
				},
				success : function(data) {
					console.log(data);
					var result = "";

					$(data)
							.each(
									function(i, v) {

										result += "<tr>" + "<td>"
												+ v[0]
												+ "</td>"
												+ "<td>"
												+ v[1]
												+ "</td>"
												+ "<td>"
												+ v[2]
												+ "</td>"
												+ "<td>"
												+ v[3]
												+ "</td>"
												+ "<td>"
												+ v[4]
												+ "</td>"
												+ "<td>"
												+ v[5]
												+ "</td>"
												+ "<td>"
												+ v[6]
												+ "</td>"
												+ "<td>"
												+ "<a href='#none'><span class='glyphicon glyphicon-pencil'></span></a>"
												+ "&nbsp;"
												+ "<a href='#none'><span class='glyphicon glyphicon-trash'></span></a>"
												+ "&nbsp;"
												+ "<a href='#none'><span class='glyphicon glyphicon-random'></span></a>"
												+ "</td>" + "</tr>"
									});
					$("#tableCustomer").html(result);
				},
				error : function(data, status, er) {
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
}

function deleteCustomer(cusID) {

	var input = {
		customerID : cusID
	}
	$.ajax({

		url : BASE_URL + "/customer/deleteCustomer",
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
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}
