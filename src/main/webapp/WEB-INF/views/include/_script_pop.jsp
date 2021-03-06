
	<script>
	var BASE_URL = "${pageContext.request.contextPath}";
	</script>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script> 
     <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script> 
    <script src="${pageContext.request.contextPath}/resources/js/jquery-dateFormat.js"></script> 
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    
    <!-- Jquery Confirm -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.confirm.min.js"></script>
    
    <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/raphael.min.js"></script>
    
     <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.min.js"></script>
     
     
     <script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
     
     <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/page/common.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
     
     <!-- Jquery validation -->
     <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/additional-methods.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/mprogress.min.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/accounting.min.js"></script>
      
      <script src="${pageContext.request.contextPath}/resources/js/jquery.simplePagination.js"></script>
      
      	<!-- RGraph Libraries -->
    <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.common.core.js"></script> 
	<script src="${pageContext.request.contextPath}/resources/libraries/RGraph.bar.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/income.js"></script>
      
	<script type="text/javascript">
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
	});
	 $.validator.addMethod("check_number", $.validator.methods.number,
	   "Please input only number");
	 $.validator.addClassRules("check_number", { check_number: true});
	 var PAGE_ID="${page_id}";	
	</script>
     
      <script type="text/javascript">
      var new_window;
		$(function(){
			 var beforePrint = function() {
					$("button").hide();
					$(".pagination").hide();
					$(".action").hide();
					$(".status").hide();
					$("#word").hide();
					$("#select_num").hide();
					$(".signature").show(); 
					$(".signature1").show(); 
			    };
			    var afterPrint = function() {
			    	$("button").show();
					$(".pagination").show();
					$(".action").show();
					$(".status").show();
					$("#word").show();
					$("#select_num").show();
					$(".signature").hide(); 
					$(".signature1").hide(); 
			    };

			    if (window.matchMedia) {
			        var mediaQueryList = window.matchMedia('print');
			        mediaQueryList.addListener(function(mql) {
			            if (mql.matches) {
			                beforePrint();
			            }else {
			                afterPrint();
			            }
			        });
			    }

			    window.onbeforeprint = beforePrint;
			    window.onafterprint = afterPrint;


			
			
// 			$("#back_up").click(function(){		
// 				startLoading();
	
// 				$.ajax({
// 					url :"${pageContext.request.contextPath}/backupandrestore/backup",
// 					type : 'GET',
// 					success : function(data) {
// 						stopLoading();
// 						//bufferProgress.end();
// 						if(data==0){
// 							alert("successfully backup");
// 						}else{
// 							alert("error update,try again");
// 							//bufferProgress.end();
// 						}
// 					},
// 					error : function(data, status, er) {
// 						//bufferProgress.end();
// 						console.log("error: " + data + " status: " + status
// 								+ " er:" + er);
// 					}
// 				}); 
// 			});
		
			 
			
			 
		});
		 function formatStringToDateTime(date,time){
				return  moment(date, "YYYYMMDD"+time).format(
					"DD-MM-YYYY"+time)
			 }
		 /**
		 * Go Back
		 */
		function goBack(controller,functionname) {
			 //location.href="${pageContext.request.contextPath}/"+controller+"/"+functionname+"";
		}
		 
		 function goBackPage(){
			 history.back();
		 }
		 function popup(url ) 
		 {
		  var width  = 1000;
		  var height = 750;
		  var left   = (screen.width  - width)/2;
		  var top    = (screen.height - height)/2;
		  var params = 'width='+width+', height='+height;
		  params += ', top='+top+', left='+left;
		  params += ', directories=no';
		  params += ', location=no';
		  params += ', menubar=no';
		  params += ', resizable=no';
		  params += ', scrollbars=no';
		  params += ', status=no';
		  params += ', toolbar=no';
		 // var newwin=
		 new_window=window.open(url,'', params);
		 return false;
		 }
		 
		 function ceilAmount(amount){
				var a1=0,a2=2,a3=0; 
				a1=((amount).toFixed(0) * 0.01);
				a2=(a1.toFixed(0));
				a3=(a2*100);
				return a3;
			}
		 
		 function checkNullOnBlue(name){
				$("#"+name).blur(function(){
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
	
			function checkNull(input,name){
				/*--  log_email  --*/
				var isnull=false;
				if(input){
					if(input!=""){
						$("#" +name).parents(".form-group").removeClass("has-error");
						$("#" +name).siblings(".help-block").hide();
					}else{
						
						isnull=true;
						$("#" +name).parents(".form-group").addClass("has-error");
						$("#" +name).siblings(".help-block").show();
						
						
					}
				}else{
					isnull=true;
					$("#" +name).parents(".form-group").addClass("has-error");
					$("#" +name).siblings(".help-block").show();
					
				}
				if(isnull){
					$("#" +name).siblings(".help-block").html("This field is required");
				}
				return isnull;
			}
			
			
			function checkLength(name,msg,length){	
				/*--  log_email  --*/
				var isFalse=false;
					if($("#"+name).val()<length){
						$("#"+name).parents(".form-group").removeClass("has-error");
						$("#"+name).siblings(".help-block").hide();
					}else{
						isFalse=true;				
						$("#"+name).parents(".form-group").addClass("has-error");
						$("#"+name).siblings(".help-block").html(msg);
						$("#"+name).siblings(".help-block").show();
					}
				
				return isFalse;
			}
			
			jQuery.fn.ForceNumericOnly =
				function()
				{
				    return this.each(function()
				    {
				        $(this).keydown(function(e)
				        {
				            var key = e.charCode || e.keyCode || 0;
				            // allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
				            // home, end, period, and numpad decimal
				            return (
				                key == 8 || 
				                key == 9 ||
				                key == 13 ||
				                key == 46 ||
				                key == 110 ||
				                key == 190 ||
				                (key >= 35 && key <= 40) ||
				                (key >= 48 && key <= 57) ||
				                (key >= 96 && key <= 105));
				        });
				    });
				};
		
	</script>

	