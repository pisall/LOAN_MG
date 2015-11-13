<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>
<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.system.loan.dto.session.USER_SESSION"%>
 
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Income</title>
    
		 <script type="text/javascript">   
			var BASE_URL = "${pageContext.request.contextPath}";  
		</script>

		
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
   </head>
   
 
   
   <%
	Date  now = new Date();
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
	String datetime = date.format(now);
	
	

 	USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
 		int strCoId;
 		String strCoNm="";
 	if(user!=null){
 		strCoId=user.getCoId();
 		strCoNm=user.getCoNm();
 		
 	}
	%>

<body> 
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<!-- Fixed Up Navigation -->
			<%@include file="include/_fixed_up_nav.jsp"%>

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
									<!-- <i class="fa fa-money fa-fw"> -->
									 Income Information
								</h3>
							</div>
							
							<div class="panel-body">
								<div class="panel panel-yellow">
									<div class="panel-heading">
										<div class="row">
											<div class="col-xs-3">
												<!-- <img src="/controller/resources/img/Income.png" height="150" width="250"> -->
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
	<!-- RGraph Libraries -->
    <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.common.core.js"></script> 
	<script src="${pageContext.request.contextPath}/resources/libraries/RGraph.bar.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/income.js"></script>
	 
	 
	 
	<script>
    window.onload = function ()
    {  
    	$.ajax({
    		url:BASE_URL+'/Income/IncomeDao',
    		type:'POST',
    		datatype:'JSON',
    		beforeSend : function(xhr) {
    			xhr.setRequestHeader("Accept", "application/json");
    			xhr.setRequestHeader("Content-Type", "application/json");
    		},
    		success:function(dat){ 
    			for(var i=0;i<dat.length;i++){  
    				var inco1 = dat[0].in1;  
 					var inco2 = dat[1].in2; 
 					var inco3 = dat[2].in3; 
 					var inco4 = dat[3].in4; 
 					var inco5 = dat[4].in5; 
 					var inco6 = dat[5].in6; 
 					var inco7 = dat[6].in7; 
 					var inco8 = dat[7].in8; 
 					var inco9 = dat[8].in9; 
 					var inco10 = dat[9].in10; 
 					var inco11 = dat[10].in11; 
 					var inco12 = dat[11].in12; 
 					
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
    			
    			
    			var data = [inco12,inco11,inco10,inco9,inco8,inco7,inco6,inco5,inco4,inco3,inco2,inco1];

    	        var bar = new RGraph.Bar({
    	            id: 'cvs',
    	            data: data,
    	            options: {
    	                backgroundGridAutofitNumvlines: 0,
    	                linewidth: 0,
    	                shadow: false,
    	                hmargin: 6,
    	                colors: ['Gradient(blue:blue:green)', 'Gradient(green:#0f0)'],
    	                labels: [mon12,mon11,mon10,mon9,mon8,mon7,mon6,mon5,mon4,mon3,mon2,mon1],
    	                clearto: 'white',
    	                variant: '3d',
    					ymin:0,
    					ymax: 6000000,
						gutterTop: 30,
						gutterLeft: 95,
						title:'Monthly Income រៀល',
		                gutterBottom:70
    	            }
    	        }).wave({frames: 60});
    	        
    		}
    	});
    	
        
    };
</script>

</body>

</html>
