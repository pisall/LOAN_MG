/**
 * 
 */
$(document).ready(function(){
	view_account();
	$("#opt_change_password").click(function(){
		changePassword();
	});
	$("#btn_change_pass_confirm").click(function(){
		var input={oldPassword:"",newPassword:"",confirmNewPassword:""};
		input["oldPassword"]=$("#old_pass").val();
		input["newPassword"]= $("#new_pass").val();
		input["confirmNewPassword"]=$("#conf_new_pass").val();
		console.log(input);
		var isError=false;
		
		if(input.oldPassword.length==0){
			$("#old_pass").parent(".form-group").addClass("has-error");
			isError=true;
		}else{
			$("#old_pass").parent(".form-group").removeClass("has-error");
		}
		
		if(input.newPassword.length==0){
			$("#new_pass").parent(".form-group").addClass("has-error");
			isError=true;
		}else{
			$("#new_pass").parent(".form-group").removeClass("has-error");
		}
		
		if(input.confirmNewPassword.length==0){
			$("#conf_new_pass").parent(".form-group").addClass("has-error");
			isError=true;
		}else{
			$("#conf_new_pass").parent(".form-group").removeClass("has-error");
		}
		
		if(isError){
			return;
		}
		
		if(input.newPassword.length!=input.confirmNewPassword.length){
			alert("New password and confirm password is not match,please reset new password");
			$("#conf_new_pass").val("");
			$("#new_pass").val("");
			
			$("#new_pass").parent(".form-group").addClass("has-error");
			$("#conf_new_pass").parent(".form-group").addClass("has-error");
			isError=true;
			
		}else{
			$("#new_pass").parent(".form-group").removeClass("has-error");
			$("#conf_new_pass").parent(".form-group").removeClass("has-error");
			
		}
		if(isError){
			return;
		}
		
		
		
		if(confirm("Do you want to change new password?"))
		{
			sendChangPassword(input);
			
		}else{
			
		}
	});
	
	//check user Name;
	$("#btn_change_username_confirm").click(function(){
		var input={oldPassword:"",newPassword:"",confirmNewPassword:""};
		input["userName"]=$("#change_user_nm").val();
		input["oldPassword"]=$("#user_nm_change_password").val();
		var isError=false;
		
		if(input.userName.length==0){
			$("#change_user_nm").parent(".form-group").addClass("has-error");
			isError=true;
		}else{
			$("#change_user_nm").parent(".form-group").removeClass("has-error");
		}
		
		if(input.oldPassword.length==0){
			$("#user_nm_change_password").parent(".form-group").addClass("has-error");
			isError=true;
		}else{
			$("#user_nm_change_password").parent(".form-group").removeClass("has-error");
		}
		
		if(isError){
			return;
		}
	
		console.log(input);
		sendChangeUserName(input);
		
	});
	
	//event on hide of modal change password
	$("#myModal").on('hidden.bs.modal', function () {
        $("#old_pass").val("");
        $("#new_pass").val("");
        $("#conf_new_pass").val("");
	});
	
	// event on hide of modal change user name
	$("#user_change").on('hidden.bs.modal', function () {
        $("#change_user_nm").val("");
        $("#user_nm_change_password").val("");
	});
	
	$("#reg_co_nm").click(function(){
		$("#reg_modal").modal("show");
	});
	
	$("#modal_close").click(function(){
		$("#reg_modal").modal("hide");
	});
	
	$("#reg_co_nm").click(function(){
		viewReg();
	});
	
	$("#opt_change_username").click(function(){
		$("#user_change").modal("show");
	});
		
});
function changePassword(){
	$("#myModal").modal("show");
}
function view_account(){
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0003",
		type : 'POST',
		dataType : 'JSON',
		//data : JSON.stringify(input),
		beforeSend : function(xhr) {
			startLoading();
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			stopLoading();
			
			var proNm="";
			if(data.co_sex=="M"){
				proNm+="Mr.";
			}else{
				proNm+="Mrs.";
			}
			proNm+=(data.co_first_nm+" "+ data.co_last_nm).replace(/\b./g, function(m){ return m.toUpperCase(); });
			$("#co_nm").text(proNm);
			$("#username").text(data.log_email);
			$("#account_type").text(data.log_type);
			$("#reg_co_nm").text(data.reg_co_first_nm+" "+data.reg_co_last_nm);
			$("#reg_co_id").val(data.reg_co_id);
			$("#reg_dtt").text(moment(data.reg_dtt, "YYYYMMDDhhmmss").format("dddd,Do MMM YYYY hh:mm:ss"));
			
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}
function sendChangPassword(input){
	$.ajax({
		url : BASE_URL + "/changePassword",
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
			if(data.ERROR){
				alert("Request is fails,please try again!");
			}else{
				alert("Successfully change password!");
				$("#myModal").modal("hide");
			}
				
			
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}
function sendChangeUserName(input){
	$.ajax({
		url : BASE_URL + "/change_user_name",
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
			console.log(data);
			if(data.ERROR){
				$("#change_user_nm").val("");
				$("#user_nm_change_password").val("");
				alert(data.MESSAGE);
				
			}else{
				alert(data.MESSAGE);
				$("#user_change").modal("hide");
			}
			
		},
		error : function(data, status, er) {
			stopLoading();
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

function viewReg(){
	var id=$("#reg_co_id").val();
	console.log("id="+id);
	var input={};
	input["co_id"]=id;
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0004",
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
			console.log(data);
			var proNm="";
			if(data.co_sex=="M"){
				proNm+="Mr.";
			}else{
				proNm+="Mrs.";
			}
			
			proNm+=(data.co_first_nm+" "+ data.co_last_nm).replace(/\b./g, function(m){ return m.toUpperCase(); });
			console.log("proName="+proNm);
			$("#view_reg_co_nm").text(proNm);
			$("#view_reg_co_brand").text(data.co_brand);
			$("#view_reg_co_phone").text(data.co_phone);
			$("#view_reg_co_cmp_phone").text(data.co_cpm_phone);
			$("#view_reg_address").text(data.address);
			
			
			
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}