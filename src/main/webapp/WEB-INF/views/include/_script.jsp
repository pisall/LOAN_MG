
	
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
     <script src="${pageContext.request.contextPath}/resources/js/page/nav.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/page/common.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
     
     <!-- Jquery validation -->
     <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/additional-methods.min.js"></script>
     
 
	<script type="text/javascript">
	jQuery.validator.setDefaults({
		  debug: true,
		  success: "valid"
	});
	 $.validator.addMethod("check_number", $.validator.methods.number,
	   "Please input only number");
	 $.validator.addClassRules("check_number", { check_number: true});
	 	
	</script>
     
      <script type="text/javascript">
		$(function(){
			$("#back_up").click(function(){
				startLoading();
				$.ajax({
					url :"${pageContext.request.contextPath}/backupandrestore/backup",
					type : 'GET',
					success : function(data) {
						stopLoading();
						if(data==0){
							alert("successfully backup");
						}
					},
					error : function(data, status, er) {
						console.log("error: " + data + " status: " + status
								+ " er:" + er);
					}
				});
			});
		
			 $( "#dob" ).datepicker({
			      showOtherMonths: true,
			      selectOtherMonths: true,
			      changeMonth: true,
			      changeYear: true,
			      dateFormat:"dd-mm-yy"
			    });
		});
	
	</script>
	