/**
 * 
 */

function startLoading(){
	var strload='<div class="modal fade in" style="display:block" data="iloading">';
	strload+=	    '<div class="col-md-12 text-center" style="height: 100%;">';
	strload+=			        '<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate" style="top: 50%;font-size: 2.3vw;"></span>'
	strload+=		    '</div>';
	strload+=	'</div>';
	strload+=	'<div class="modal fade in" style="display:block;background-color: #3C3636;opacity: 0.2;" data="iloading">';
	strload+=	'</div>';
	
	var ele=$('[data=iloading]');
	if(ele.length>0){
		
	}else{
		$("body").append(strload);
	}
	
}
function stopLoading(){
	var ele=$('[data=iloading]');
	ele.remove();
}