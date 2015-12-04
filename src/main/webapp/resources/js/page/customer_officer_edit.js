/**
 * 
 */

$(document).ready(function(){
	//blur event
	onblur();
	$("#btn_save").click(function(){
		coupdate();
	});
	viewCustomer(ID);
	//console.log("id==="+ID);
	
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

function onblur(){
	
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
	var error=false;
	
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
function coupdate(){
	var input={};
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
	
	console.log(input);
	//pb_adress
	//return;
	
	if(validation(input)){
		return;
	}
	console.log("start");
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
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
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