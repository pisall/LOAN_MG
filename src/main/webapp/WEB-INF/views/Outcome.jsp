
<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">

<head>
	<!-- Chat Libraries --> 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content=""> 
    <title>Outcome</title> 
		 <script type="text/javascript">   
			var BASE_URL = "${pageContext.request.contextPath}";  
		</script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>	 
    <%-- <script src="${pageContext.request.contextPath}/resources/js/outcome.js"></script> --%>
		
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
   <!-- RGraph Libraries -->
   <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.common.core.js"></script>  
   <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.bar.js"></script>
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
   
     <style type="text/css">
     	table tr th{
     		    background-color: #638BE0 !important;
    			color: #fff;
     	}
     	#customer_detail th{
     		width: 22%;
     	}
     </style>  
</head>

<body>   
 
 		<script>
	    $(function () 
		    {  
		 		$.ajax({
		 			url:BASE_URL+'/Outcome/OutcomeDao',
		 			type:'POST',
		 			datatype:'JSON',
		 			beforeSend : function(xhr) {
		 				xhr.setRequestHeader("Accept", "application/json");
		 				xhr.setRequestHeader("Content-Type", "application/json");
		 			},
		 			success:function(dat){  
		 				for(var i=0;i<dat.length;i++){
		 					var out1 = dat[0].out1;
		 					var out2 = dat[1].out2; 
		 					var out3 = dat[2].out3; 
		 					var out4 = dat[3].out4; 
		 					var out5 = dat[4].out5; 
		 					var out6 = dat[5].out6; 
		 					var out7 = dat[6].out7; 
		 					var out8 = dat[7].out8; 
		 					var out9 = dat[8].out9; 
		 					var out10 = dat[9].out10; 
		 					var out11 = dat[10].out11; 
		 					var out12 = dat[11].out12; 
		 					
		 					var mon1 = dat[0].mon1;
		 					var mon2 = dat[1].mon2; 
		 					var mon3 = dat[2].mon3; 
		 					var mon4 = dat[3].mon4; 
		 					var mon5 = dat[4].mon5; 
		 					var mon6 = dat[5].mon6; 
		 					var mon7 = dat[6].mon7; 
		 					var mon8 = dat[7].mon8; 
		 					var mon9 = dat[8].mon9; 
		 					var mon10 = dat[9].mon10; 
		 					var mon11 = dat[10].mon11; 
		 					var mon12 = dat[11].mon12; 
		 					
		 				}
		 				var data=[out12,out11,out10,out9,out8,out7,out6,out5,out4,out3,out2,out1];
				        var bar = new RGraph.Bar({
				            id: 'cvs',
				            data: data,
				            options: {
				                backgroundGridAutofitNumvlines: 0,
				                linewidth: 0,
				                shadow: false,
				                hmargin: 6,
				                colors: ['Gradient(pink:red:#f33)', 'Gradient(green:#0f0)'],
				                labels: [mon12,mon11,mon10,mon9,mon8,mon7,mon6,mon5,mon4,mon3,mon2,mon1],
				                clearto: 'white',
				                variant: '3d',
								ymin:0,
								ymax: 6000000,
								gutterTop: 30,
								gutterLeft: 95,
								title:'Monthly Outcome រៀល',
				                gutterBottom:70
				            }
				        }).wave({frames: 60});
				      
		 			} 
		        
		 		});
		    });
		</script>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<!-- Fixed Up Navigation -->
			<%-- <%@include file="include/_fixed_up_nav.jsp"%> --%>

			<!-- Side Bar Navigation -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<%@include file="include/_side_nav.jsp"%>
			</div>

		</nav>
		<!-- End Navigation --> 
		<div id="page-wrapper">

			<div class="container-fluid"> 
					<div class="col-lg-6" style="width:600px;height:550px;">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"></i> -->
									Outcome Information
								</h3>
							</div>
							
							<div class="panel-body">
								<div class="panel panel-red">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3" >
												<!-- <img src="/controller/resources/img/Outcome1.png" height="150" width="250"> -->
											<canvas id="cvs" width="500" height="300">[No canvas support]</canvas>
											</div>
											<!-- <div class="col-xs-9 text-right">
												<div class="huge">124</div>
												<div>New Orders!</div>
											</div> -->
										</div>
									</div> 
								</div>
							</div>
						</div>
					</div> 
				</div>  
			</div>  
		</div>
		
		
	<%@include file="include/_script.jsp"%> 
	 <script type="text/javascript">
	 var PAGE_ID="${page_id}";
	 </script>
	
		
</body>

</html>

