/**
 * 
 */

$(document).ready(function(){
	//blur event
	onblur();
	
	$("#btn_save").click(function(){
		coInsert(false);
	});
	
	
});

function onblur(){
	$("#user_nm").blur(function(){
		var txt="";
		txt=$(this).val();
		if(txt==""){
			$(this).siblings(".help-block").show();
			$(this).parents(".form-group").addClass("has-error");
		}else{
			$(this).parents(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").hide();
		}
	});
	
	$("#password").blur(function(){
		var txt="";
		txt=$(this).val();
		if(txt==""){
			$(this).siblings(".help-block").show();
			$(this).parents(".form-group").addClass("has-error");
		}else{
			$(this).parents(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").hide();
		}
	});
	
	$("#c_password").blur(function(){
		var txt="";
		txt=$(this).val();
		if(txt==""){
			$(this).siblings(".help-block").show();
			$(this).parents(".form-group").addClass("has-error");
		}else{
			$(this).parents(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").hide();
		}
	});
	
	$("#national_id").blur(function(){
		var txt="";
		txt=$(this).val();
		if(txt==""){
			$(this).siblings(".help-block").show();
			$(this).parents(".form-group").addClass("has-error");
		}else{
			$(this).parents(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").hide();
		}
	});
	
	$("#phone").blur(function(){
		var txt="";
		txt=$(this).val();
		if(txt==""){
			$(this).siblings(".help-block").show();
			$(this).parents(".form-group").addClass("has-error");
		}else{
			$(this).parents(".form-group").removeClass("has-error");
			$(this).siblings(".help-block").hide();
		}
	});
}


function validation(input){
	/*--  log_email  --*/
	var error=false;
	if(input.log_email){
		if(input.log_email!=""){
			$("#user_nm").parents(".form-group").removeClass("has-error");
			$("#user_nm").siblings(".help-block").hide();
		}else{
			error=true;
			$("#user_nm").parents(".form-group").addClass("has-error");
			$("#user_nm").siblings(".help-block").show();
			
		}
	}else{
		error=true;
		$("#user_nm").parents(".form-group").addClass("has-error");
		$("#user_nm").siblings(".help-block").show();
		
	}
	/*--  //log_email  --*/
	
	/*--  log_password  --*/
	if(input.log_password){
		if(input.log_password!=""){
			$("#password").parents(".form-group").removeClass("has-error");
			$("#password").siblings(".help-block").hide();
		}else{
			error=true;
			$("#password").parents(".form-group").addClass("has-error");
			$("#password").siblings(".help-block").show();
			
		}
	}else{
		error=true;
		$("#password").parents(".form-group").addClass("has-error");
		$("#password").siblings(".help-block").show();
		
	}
	/*--  //log_password  --*/
	
	/*--  confirm_password  --*/
	if(input.confirm_password){
		if(input.confirm_password!=""){
			$("#c_password").parents(".form-group").removeClass("has-error");
			$("#c_password").siblings(".help-block").hide();
		}else{
			error=true;
			$("#c_password").parents(".form-group").addClass("has-error");
			$("#c_password").siblings(".help-block").show();
			
		}
	}else{
		error=true;
		$("#c_password").parents(".form-group").addClass("has-error");
		$("#c_password").siblings(".help-block").show();
		
	}
	/*--  //confirm_password  --*/
	
	/*--  Nation_card  --*/
	if(input.co_national_id){
		if(input.co_national_id!=""){
			$("#national_id").parents(".form-group").removeClass("has-error");
			$("#national_id").siblings(".help-block").hide();
		}else{
			error=true;
			$("#national_id").parents(".form-group").addClass("has-error");
			$("#national_id").siblings(".help-block").show();
			
		}
	}else{
		error=true;
		$("#national_id").parents(".form-group").addClass("has-error");
		$("#national_id").siblings(".help-block").show();
		
	}
	/*--  //Nation card  --*/
	
	
	/*--  Phone  --*/
	if(input.co_phone){
		if(input.co_phone!=""){
			$("#phone").parents(".form-group").removeClass("has-error");
			$("#phone").siblings(".help-block").hide();
		}else{
			error=true;
			$("#phone").parents(".form-group").addClass("has-error");
			$("#phone").siblings(".help-block").show();
			
		}
	}else{
		error=true;
		$("#phone").parents(".form-group").addClass("has-error");
		$("#phone").siblings(".help-block").show();
		
	}
	/*--  //Phone  --*/
	
	return error;
}
function coInsert(isNew){
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
	
	console.log(input);
	//pb_adress
	//return;
	
	if(validation(input)){
		return;
	}
	
	//return;
	$.ajax({
		url : BASE_URL + "/sys/sys_req",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			console.log("before sent");
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