$(function() {
	var page_no = 1;
	var value = {};
	var totalPage = 0;

	listCus(page_no);

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
		if (page_no < 1) {
			page_no = 1
			alert("cannot previous");
		}

		listCus(page_no);

	});
}

function showPagin(totalPage, curPage) {
	$("#paging").html("");
	$("#paging").append('<li id="p_pre" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>');
	for (var i = 1; i <= totalPage; i++) {
		if (i == curPage)
			$("#paging").append('<li class="active"  name="p_index"><a href="#none">'	+ i + '</a></li>');

		else
			$("#paging").append('<li  name="p_index"><a href="#none">'	+ i + '</a></li>');

	}
	
	$("#paging").append('<li id="p_next" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>');
	
	
//	var previous = '<li id="p_pre" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
//	var number = '<li class=' + active + '  name="p_index"><a href="#none">'
//			+ i + '</a></li>';
//	var next = '<li id="p_next" class="next"><a href="#none"><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
//	var paging = previous + number + next;
//	return paging;
}

function listCus(pageNo) {
	var input = {
		pageNo : pageNo,
		sw : ''
	}
	$.ajax({

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
					var totalPage = parseInt(paging.totalPage);
					
					// clear paging
					$("#paging").html("");

					//load totalpage
					
					showPagin(totalPage, curPage)
					
					//loadTotalPage(totalPage, curPage)
					
					if(data.REC.length > 0){
						
						for(var i=0;i<data.REC.length;i++){
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
							+ "<a href='#none'><span class='glyphicon glyphicon-pencil'></span></a>"
							+ "&nbsp;"
							+ "<a href='#none' onclick=\"return deleteCustomer("+data.REC[i].cuID+")\"><span class='glyphicon glyphicon-trash'></span></a>"
							+ "&nbsp;"
							+ "<a href='#none'><span class='glyphicon glyphicon-random'></span></a>"
							+ "</td>" + "</tr>"
						}
						
						
					}
					
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

/**
 * Delete customer 
 * @param cusID
 */

function deleteCustomer(cusID) {

	$.confirm({
		text : "Are you sure you want to delete this record?",
		confirm : function() {
			var input = {
					cuID : cusID
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
						alert(page_no);
						listCus(page_no);
					},
					error : function(data, status, er) {
						console.log("error: " + data + " status: " + status + " er:"
								+ er);
					}
				});
			
		},
		cancel : function() {
			
		}
	});
		
}
/*
function loadTotalPage(totalPage,curPage){
	
//	for (var i = 1; i <= totalPage; i++) {
//		if (i == curPage)
//			$("#paging").html(showPagin('active', i));
//
//		else
//			$("#paging").html(showPagin('', i));
//
//	}
	
	showPagin(totalPage, curPage)
	
	
	
}*/


