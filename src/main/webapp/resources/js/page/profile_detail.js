/**
 * 
 */

$(document).ready(function(){
	getCoById();
});


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
			$("#co_reg_dtt").text($.format.date(new Date(convertToStandardDateString(data.reg_dtt)),"ddd,MMM dd yyyy"));
			//$("#co_reg_dtt").text(convertToStandardDateString(data.reg_dtt));
			$("#co_update_dtt").text(data.update_dtt);
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