/**
 * 
 */
$(document).ready(function(){
	view_account();
	$("#opt_change_password").click(function(){
		changePassword();
	});
	$("#btn_change_pass_confirm").click(function(){
		removeError();
		var input={oldPassword:"",newPassword:"",confirmNewPassword:""};
		input["oldPassword"]=$("#old_pass").val();
		input["newPassword"]= $("#new_pass").val();
		input["confirmNewPassword"]=$("#conf_new_pass").val();
		
		if(!validationLogPwd()){
			return;
		}
		if(confirm("Do you want to change new password?"))
		{
			sendChangPassword(input);
		};
	});
	
	//check user Name;
	$("#btn_change_username_confirm").click(function(){
		removeError();
		var input={oldPassword:"",newPassword:"",confirmNewPassword:""};
		input["userName"]=$("#change_user_nm").val();
		input["oldPassword"]=$("#user_nm_change_password").val();
		
		if(!validationLogId()){
			return;
		}
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
function validationLogId(){
	var username = $("#change_user_nm").val();
	if(username == "") {
		alert("Error: Username cannot be blank!");
		$("#change_user_nm").parents(".form-group").addClass("has-error");
		$("#change_user_nm").focus();
		return false;
	}
	re = /^\w+$/;
	if(!re.test(username)) {
	  $("#change_user_nm").parents(".form-group").addClass("has-error");
	  alert("Error: Username must contain only letters, numbers and underscores!");
	  $("#change_user_nm").focus();
	  return false;
	}
	removeError();
	return true;
}
function validationLogPwd(){
	var pw1 = $("#new_pass").val();
	var pw2 = $("#conf_new_pass").val();
	var oldpw = $("#old_pass").val();

	if(oldpw=="") {
	  $("#old_pass").parents(".form-group").addClass("has-error");
	  alert("Error: Old Password can not be blank!");
	  $("#old_pass").focus();
	  return false;
	}
	
	if(pw1 != "" && pw1 == pw2) {
	  if(pw1.length < 6) {
		  $("#new_pass").parents(".form-group").addClass("has-error");
		  alert("Error: Password must contain at least six characters!");
		  $("#new_pass").focus();
		  return false;
	  }
	  re = /[0-9]/;
	  if(!re.test(pw1)) {
	    $("#new_pass").parents(".form-group").addClass("has-error");
	    alert("Error: password must contain at least one number (0-9)!");
	    $("#new_pass").focus();
	    return false;
	  }
	  re = /[a-z]/;
	  if(!re.test(pw1)) {
	    $("#new_pass").parents(".form-group").addClass("has-error");
	    alert("Error: password must contain at least one lowercase letter (a-z)!");
	    $("#new_pass").focus();
	    return false;
	  }
	  re = /[A-Z]/;
	  if(!re.test(pw1)) {
	    $("#new_pass").parents(".form-group").addClass("has-error");
	   alert("Error: password must contain at least one uppercase letter (A-Z)!");
	    $("#new_pass").focus();
	    return false;
	  }
	} else {
	  $("#conf_new_pass").parents(".form-group").addClass("has-error");
	  alert("Error: Please check that you've entered and confirmed your password!");
	  $("#conf_new_pass").focus();
	  return false;
	}

	removeError();
	return true;
}
function removeError(){
	 $("#old_pass").parents(".form-group").removeClass("has-error");
	  $("#new_pass").parents(".form-group").removeClass("has-error");
	  $("#conf_new_pass").parents(".form-group").removeClass("has-error");
};
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