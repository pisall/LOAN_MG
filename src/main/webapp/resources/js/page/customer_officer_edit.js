/**
 * 
 */

$(document).ready(function(){
	if(_role == "ROLE_USER"){
		$("#ACCOUNT_INFO").remove();
	};
	$("#btn_save").click(function(){
		coupdate();
	});
	viewCustomer(ID);
	
	//evetn
	$("#phone").keyup(function(){
		var strPhone=$(this).val();
		$("#lb_phone").text(strPhone.replace(/(\d{3})(\d{3})(\d{1})/, "$1 $2-$3"));
	});
	
	$("#cpm_phone").keyup(function(){
		var strPhone=$(this).val();
		$("#lb_office_phone").text(strPhone.replace(/(\d{3})(\d{3})(\d{1})/, "$1 $2-$3"));
	});
	
});

function getCoById(input){
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0002",
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

function validation(){
	  username = $("#user_nm").val();
	  pw1 = $("#password").val();
	  id = $("#national_id").val();
	  phone = $("#phone").val();
	  if(username == "") {
	    $("#user_nm").siblings(".help-block").show();
	    $("#user_nm").parents(".form-group").addClass("has-error");
	    $("#user_nm").siblings(".help-block").find("li").text("Error: Username cannot be blank!");
	    $("#user_nm").focus();
	    return false;
	  }
	  re = /^\w+$/;
	  if(!re.test(username)) {
		$("#user_nm").siblings(".help-block").show();
	    $("#user_nm").parents(".form-group").addClass("has-error");
	    $("#user_nm").siblings(".help-block").find("li").text("Error: Username must contain only letters, numbers and underscores!");
	    $("#user_nm").focus();
	    return false;
	  }

	  if(pw1 != "") {
	    if(pw1.length < 6) {
	  	$("#password").siblings(".help-block").show();
	    $("#password").parents(".form-group").addClass("has-error");
	    $("#password").siblings(".help-block").find("li").text("Error: Password must contain at least six characters!");
	    $("#password").focus();
	    return false;
	    }
	    if(pw1 == username) {
	    	$("#password").siblings(".help-block").show();
	        $("#password").parents(".form-group").addClass("has-error");
	        $("#password").siblings(".help-block").find("li").text("Error: Password must be different from Username!");
	        $("#password").focus();
	        return false;
	    }
	    re = /[0-9]/;
	    if(!re.test(pw1)) {
	      $("#password").siblings(".help-block").show();
	      $("#password").parents(".form-group").addClass("has-error");
	      $("#password").siblings(".help-block").find("li").text("Error: password must contain at least one number (0-9)!");
	      $("#password").focus();
	      return false;
	    }
	    re = /[a-z]/;
	    if(!re.test(pw1)) {
	      $("#password").siblings(".help-block").show();
	      $("#password").parents(".form-group").addClass("has-error");
	      $("#password").siblings(".help-block").find("li").text("Error: password must contain at least one lowercase letter (a-z)!");
	      $("#password").focus();
	      return false;
	    }
	    re = /[A-Z]/;
	    if(!re.test(pw1)) {
	      $("#password").siblings(".help-block").show();
	      $("#password").parents(".form-group").addClass("has-error");
	      $("#password").siblings(".help-block").find("li").text("Error: password must contain at least one uppercase letter (A-Z)!");
	      $("#password").focus();
	      return false;
	    }
	  } else {
	    $("#password").siblings(".help-block").show();
	    $("#password").parents(".form-group").addClass("has-error");
	    $("#password").siblings(".help-block").find("li").text("Error: Please check that you've your password!");
	    $("#password").focus();
	    return false;
	  }

	  //National ID and phone number
	  re = /[0-9]/;
	  re1 = /[a-z]/;
	  re2 =/[A-Z]/;
	  if(id=="") {
	    $("#national_id").siblings(".help-block").show();
	    $("#national_id").parents(".form-group").addClass("has-error");
	    $("#national_id").siblings(".help-block").find("li").text("Error: National ID can not be blank!");
	    $("#national_id").focus();
	    return false;
	  }
	  if(!re.test(id) || re1.test(id) || re2.test(id)) {
	    $("#national_id").siblings(".help-block").show();
	    $("#national_id").parents(".form-group").addClass("has-error");
	    $("#national_id").siblings(".help-block").find("li").text("Error: National ID must contain only number (0-9)!");
	    $("#national_id").focus();
	    return false;
	  }
	  if(phone=="") {
	    $("#phone").siblings(".help-block").show();
	    $("#phone").parents(".form-group").addClass("has-error");
	    $("#phone").siblings(".help-block").find("li").text("Error: phone nubmer can not be blank!");
	    $("#phone").focus();
	    return false;
	  }
	  if(!re.test(phone) || re1.test(phone) || re2.test(phone)) {
	    $("#phone").siblings(".help-block").show();
	    $("#phone").parents(".form-group").addClass("has-error");
	    $("#phone").siblings(".help-block").find("li").text("Error: phone id invalid!");
	    $("#phone").focus();
	    return false;
	  }
	  removeError();
	  return true;
	}

function removeError(){
	 $("#user_nm").parents(".form-group").removeClass("has-error");
	  $("#user_nm").siblings(".help-block").hide();
	  $("#password").parents(".form-group").removeClass("has-error");
	  $("#password").siblings(".help-block").hide();
	  $("#national_id").parents(".form-group").removeClass("has-error");
	  $("#national_id").siblings(".help-block").hide();
	  $("#phone").parents(".form-group").removeClass("has-error");
	  $("#phone").siblings(".help-block").hide();
};
function coupdate(){
	removeError();
	var input={};
	input['log_email']=$("#user_nm").val();
	if($("#password").val() !="sameoldone"){
		input['log_password']=$("#password").val();
	}else{
		input['log_password']="";
	};
	input['log_type'] = $("#role").val();
	input['log_in'] = $("#log_in").val();
	input['co_id']=ID;
	input['co_first_nm']=$("#first_nm").val();
	input['co_last_nm']=$("#last_nm").val();
	input['co_sex']=$("input:radio[name=sex]:checked").val();
	input['co_national_id']=$("#national_id").val();
	input['co_brand']=$("#brand").val();
	input['co_phone']=$("#phone").val();
	input['co_cpm_phone']=$("#cpm_phone").val();
	input['dob']=$("#dob").val().replace(/-/g, '');
	input['address']=$("#address").val();
	input['co_pb_address']=$('#pb_adress').val();
	if(!validation(input)){
		return;
	}
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_u0003",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			if(!data.ERROR){
				console.log(data);
				alert("Successful update!.");
				//viewCustomer(ID);
				window.location.href = BASE_URL+"/co_001_controller/co_0003";
			}else{
				alert("upating is fail.");
			}
			
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}

function viewCustomer(id){
	var input={};
	input["co_id"]=parseInt(id);
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0002",
		type : 'POST',		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
			$("#user_nm").val(data.log_email);
			$("#password").val("sameoldone");
			$("#log_in").val(data.log_in);
			$("#role").val(data.log_type);
			$("#first_nm").val(data.co_first_nm);
			$("#last_nm").val(data.co_last_nm);
			$("#national_id").val(data.co_national_id);
			var sex=data.co_sex;
			$("input[name=sex][value="+sex+"]").attr('checked', true);
			var strDat=data.dob;
			if(strDat){
				if(strDat.length>=8){
					
				}
			}
			strDat=strDat.substring(0,4)+"-"+strDat.substring(4,6)+"-"+strDat.substring(6,8);
			$("#dob").val(strDat);
			$("#phone").val(data.co_phone);
			$("#cpm_phone").val(data.co_cpm_phone);
			$("#pb_adress").val(data.co_pb_address);
			$("#address").val(data.address);
			$("#brand").val(data.co_brand);
			$("#lb_phone").text(data.co_phone.replace(/(\d{3})(\d{3})(\d{4})/, "$1 $2-$3"));
			$("#lb_office_phone").text(data.co_cpm_phone.replace(/(\d{3})(\d{3})(\d{4})/, "$1 $2-$3"))
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}