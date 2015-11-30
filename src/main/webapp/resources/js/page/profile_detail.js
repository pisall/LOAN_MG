/**
 * 
 */

$(document).ready(function(){
	getCoById();
	
	$("#btn_edit_mod").click(function(){
		chageEditMode(this)
		
		
	});
});

function chageEditMode(obj){
	var text="";
	//$("#co_brand")
	text=$("#co_brand").text();
	$("#co_brand").text("").append(strInput(text));
	
	text=$("#co_national_id").text();
	$("#co_national_id").text("").append(strInput(text));
	
	text=$("#co_dob").text();
	$("#co_dob").text("").append('<input data-provide="datepicker" type="date" class="form-control datepicker" placeholder="Date of Birth" style="width:50%;">');
	$("#co_dob").children("input").val(moment(text,"ll").format("YYYY-MM-DD"));
	
	text=$("#co_phone").text();
	$("#co_phone").text("").append(strInput(text));
	
	text=$("#co_office_phone").text();
	$("#co_office_phone").text("").append(strInput(text));
	
	text=$("#co_pb_address").text();
	$("#co_pb_address").text("").append(strInput(text));
	
	text=$("#co_address").text();
	$("#co_address").text("").append(strInput(text));
	
	$(obj).after('<a href="#none" id="btn_save" class="btn btn-primary" style="position: absolute;bottom: 5px;right: 7px;">Save</a>');
	$(obj).remove();
	
	$("#btn_save").click(function(){
		save(this)
		
	});
}


function save(obj){
	var input={};
	
	input.dob=$("#co_dob").children("input").val().replace(/-/g,"");
	input.co_national_id=$("#co_national_id").children("input").val();
	input.co_brand=$("#co_brand").children("input").val();
	input.co_phone=$("#co_phone").children("input").val();
	input.co_cpm_phone=$("#co_office_phone").children("input").val();
	input.co_pb_address=$("#co_pb_address").children("input").val();
	input.address=$("#co_address").children("input").val();
	console.log(input);
	
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_u0005",
		type : 'POST',
		dataType : 'JSON',
		data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			
			$(obj).after('<a href="#none" class="edit" id="btn_edit_mod"><span class="glyphicon glyphicon-edit"></span></a>');
			$(obj).remove();
			getCoById();
			$("#btn_edit_mod").click(function(){
				chageEditMode(this);
			});
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}});
	
	
	
	
}

function strInput(text){
	var strinput='<input type="text" value="'+text+'" style="width:50%" class="form-control"/>'
	return strinput;
}
function getCoById(){
	$.ajax({
		url : BASE_URL + "/co_001_controller/co_l0003",
		type : 'POST',
		dataType : 'JSON',
		//data : JSON.stringify(input),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			console.log(data);
			$("#co_brand").text(data.co_brand);
			$("#co_phone").text(data.co_phone);
			$("#co_national_id").text(data.co_national_id);
			$("#co_office_phone").text(data.co_cpm_phone);
			$("#co_pb_address").text(data.co_pb_address);
			$("#co_address").text(data.address);
			$("#co_reg_nm").text(data.reg_co_first_nm+" "+data.reg_co_last_nm);
			$("#co_dob").text(moment(data.dob,"YYYYMMDD").format('ll'));
			$("#co_reg_dtt").text($.format.date(new Date(convertToStandardDateString(data.reg_dtt)),"ddd,MMM dd yyyy"));
			//$("#co_reg_dtt").text(convertToStandardDateString(data.reg_dtt));
			if(data.update_dtt.length==14 ){
				$("#co_update_dtt").parents("tr").css("display","");
				$("#co_update_dtt").text(moment(data.update_dtt,"YYYYMMDDhmmss").format("MMMM Do YYYY, h:mm:ss a"));
			}else{
				$("#co_update_dtt").parents("tr").css("display","none");
			}
			
			
			var proNm="";
			if(data.co_sex=="M"){
				proNm+="Mr.";
			}else{
				proNm+="Mrs.";
			}
			proNm+=(data.co_first_nm+" "+ data.co_last_nm).replace(/\b./g, function(m){ return m.toUpperCase(); });
			$("#pro_nm").text(proNm);
			
		},
		error : function(data, status, er) {
			console.log("error: " + data + " status: " + status + " er:" + er);
		}
	});
}