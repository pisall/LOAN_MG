/**
 * 
 */
$(document).ready(function(){
	
	$.ajax({
		url:BASE_URL+'/Outcome/OutcomeDao',
		type:'POST',
		datatype:'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			console.log(dat); 
			console.log(dat.length);
			
			for(var i=0;i<dat.length;i++){
				
				document.getElementById('out1').value=dat[i].out1;
				document.getElementById('out2').value=dat[i].out2;
				document.getElementById('out3').value=dat[i].out3;
				document.getElementById('out4').value=dat[i].out4;
				document.getElementById('out5').value=dat[i].out5;
				document.getElementById('out6').value=dat[i].out6;
				document.getElementById('out7').value=dat[i].out7;
				document.getElementById('out8').value=dat[i].out8;
				document.getElementById('out9').value=dat[i].out9;
				document.getElementById('out10').value=dat[i].out10;
				document.getElementById('out11').value=dat[i].out11; 
				
				
				document.getElementById('mon1').value=dat[i].mon1;
				document.getElementById('mon2').value=dat[i].mon2;
				document.getElementById('mon3').value=dat[i].mon3;
				document.getElementById('mon4').value=dat[i].mon4;
				document.getElementById('mon5').value=dat[i].mon5;
				document.getElementById('mon6').value=dat[i].mon6;
				document.getElementById('mon7').value=dat[i].mon7;
				document.getElementById('mon8').value=dat[i].mon8;
				document.getElementById('mon9').value=dat[i].mon9;
				document.getElementById('mon10').value=dat[i].mon10;
				document.getElementById('mon11').value=dat[i].mon11;
				document.getElementById('mon12').value=dat[i].mon12;
			}
			
			
		}
	});
});