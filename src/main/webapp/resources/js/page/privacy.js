/**
 * 
 */
$(document).ready(function(){
	getPrivacy();
	$("#btn_switch_edit").on('switchChange.bootstrapSwitch', function(event, state) {
		  console.log(state); // true | false
		  changeEdit(state);
	});
	
	
});

function changeEdit(isOtherEditProf){
	console.log("isotheredit pro="+isOtherEditProf);
	var input={co_id:0,co_nm:"",enabled:false,other_edit_prof:false}
	input.other_edit_prof=isOtherEditProf;
	console.log(input);
	$.ajax({
		url : BASE_URL + "/co_001_controller/change_other_edit_prof",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			//startLoading();
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			stopLoading();
			getPrivacy();
			
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

function getPrivacy(){
	//request_privacy
	$.ajax({
		url : BASE_URL + "/co_001_controller/request_privacy",
		type : 'POST',
		dataType : 'JSON',
		//data : JSON.stringify(input),
		beforeSend : function(xhr) {
			//startLoading();
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			//stopLoading();
			$('#btn_switch_edit').bootstrapSwitch('state', data.other_edit_prof);
			
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}
