/**
 * 
 */
$(function(){
	$("#test").click(function(){
		listCo();
	});
	
	
	
});

function listCo(pageNo) {
	var input = {paging:{pageNo:2,pcnt:3,total:0,totalPage:10}};
	$
			.ajax({

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
					console.log("error: " + data + " status: " + status
							+ " er:" + er);
				}
			});
}