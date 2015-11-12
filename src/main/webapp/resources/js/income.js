/**
 * 
 */
$(document).ready(function(){
	
	$.ajax({
		url:BASE_URL+'/Income/IncomeDao',
		type:'POST',
		datatype:'JSON',
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success:function(dat){
			console.log(dat);  
			for(var i=0;i<dat.length;i++){  
				document.getElementById('in1').value=dat[i].in1;
				document.getElementById('in2').value=dat[i].in2;
				document.getElementById('in3').value=dat[i].in3;
				document.getElementById('in4').value=dat[i].in4;
				document.getElementById('in5').value=dat[i].in5;
				document.getElementById('in6').value=dat[i].in6;
				document.getElementById('in7').value=dat[i].in7;
				document.getElementById('in8').value=dat[i].in8;
				document.getElementById('in9').value=dat[i].in9;
				document.getElementById('in10').value=dat[i].in10;
				document.getElementById('in11').value=dat[i].in11; 
				document.getElementById('in12').value=dat[i].in12; 
				
				
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