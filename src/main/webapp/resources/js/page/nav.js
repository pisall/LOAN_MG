/**
 * 
 */

$(document).ready(function(){
	if(typeof PAGE_ID!="undefined"){
		$("#nav li[val="+PAGE_ID+"]").addClass("active");
	}
	
});
function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
    	var cookie = cookies[i];
    	var eqPos = cookie.indexOf("=");
    	var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
    	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function click_setting(){
	$("#setting").click(function(){
		//alert("test");
		var input={};
		input["oldPassword"]="124";
		input["newPassword"]="123";
		input["confirmNewPassword"]="123";
		
		
		$.ajax({
			url : BASE_URL + "/changePassword",
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
	});
}