/**
 * 
 */

$(document).ready(function(){
	//blur event
//	onblur();
	
	$("#btn_save").click(function(){
		coInsert(false);
	});
	$("#btn_save_new").click(function(){
		coInsert(true);
	});
	
});

function validation(){
 var username = $("#user_nm").val();
 var pw1 = $("#password").val();
 var pw2 = $("#c_password").val();
 var id = $("#national_id").val();
 var phone = $("#phone").val();
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

  if(pw1 != "" && pw1 == pw2) {
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
    $("#c_password").siblings(".help-block").show();
    $("#c_password").parents(".form-group").addClass("has-error");
    $("#c_password").siblings(".help-block").find("li").text("Error: Please check that you've entered and confirmed your password!");
    $("#c_password").focus();
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
	  $("#c_password").parents(".form-group").removeClass("has-error");
	  $("#c_password").siblings(".help-block").hide();
	  $("#national_id").parents(".form-group").removeClass("has-error");
	  $("#national_id").siblings(".help-block").hide();
	  $("#phone").parents(".form-group").removeClass("has-error");
	  $("#phone").siblings(".help-block").hide();
};
function coInsert(isNew){
	removeError();
	var input={};
	input['co_first_nm']=$("#first_nm").val();
	input['co_last_nm']=$("#last_nm").val();
	input['co_sex']=$("input:radio[name=sex]:checked").val();
	input['co_national_id']=$("#national_id").val();
	input['co_brand']=$("#brand").val();
	input['co_phone']=$("#phone").val();
	input['co_cpm_phone']=$("#cpm_phone").val();
	input['dob']=$("#dob").val().replace(/-/g,"");
	input['address']=$("#address").val();
	input['co_pb_address']=$("#pb_adress").val();
	input['log_email']=$("#user_nm").val();
	input['log_password']=$("#password").val();
	input['confirm_password']=$("#c_password").val();
	
	if(!validation()){
		return;
	}
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_c0001",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			alert("New CO created successfully!")
			if(isNew){
				window.location.href = BASE_URL+"/co_001_controller/co_0001";
			}else{
				window.location.href = BASE_URL+"/co_001_controller/co_0003";
			}
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}