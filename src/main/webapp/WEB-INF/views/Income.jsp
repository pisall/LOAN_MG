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

<input type ="hidden" id="in1" value=""/>
<input type ="hidden" id="in2" value=""/>
<input type ="hidden" id="in3" value=""/>
<input type ="hidden" id="in4" value=""/>
<input type ="hidden" id="in5" value=""/>
<input type ="hidden" id="in6" value=""/>
<input type ="hidden" id="in7" value=""/>
<input type ="hidden" id="in8" value=""/>
<input type ="hidden" id="in9" value=""/>
<input type ="hidden" id="in10" value=""/>
<input type ="hidden" id="in11" value=""/>
<input type ="hidden" id="in12" value=""/>

<input type ="hidden" id="mon1" value=""/>
<input type ="hidden" id="mon2" value=""/>
<input type ="hidden" id="mon3" value=""/>
<input type ="hidden" id="mon4" value=""/>
<input type ="hidden" id="mon5" value=""/>
<input type ="hidden" id="mon6" value=""/>
<input type ="hidden" id="mon7" value=""/>
<input type ="hidden" id="mon8" value=""/>
<input type ="hidden" id="mon9" value=""/>
<input type ="hidden" id="mon10" value=""/>
<input type ="hidden" id="mon11" value=""/>
<input type ="hidden" id="mon12" value=""/>




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
    	var in1 = document.getElementById('in1').value;
    	var inco1 = in1.slice(0,3);
    	var in2 = document.getElementById('in2').value;
    	var inco2 = in2.slice(0,3);
    	var in3 = document.getElementById('in3').value;
    	var inco3 = in3.slice(0,3);
    	var in4 = document.getElementById('in4').value;
    	var inco4 = in4.slice(0,3);
    	var in5 = document.getElementById('in5').value;
    	var inco5 = in5.slice(0,3);
    	var in6 = document.getElementById('in6').value;
    	var inco6 = in6.slice(0,3);
    	var in7 = document.getElementById('in7').value;
    	var inco7 = in7.slice(0,3);
    	var in8 = document.getElementById('in8').value;
    	var inco8 = in8.slice(0,3);
    	var in9 = document.getElementById('in9').value;
    	var inco9 = in9.slice(0,3);
    	var in10 = document.getElementById('in10').value;
    	var inco10 = in10.slice(0,3);
    	var in11 = document.getElementById('in11').value;
    	var inco11 = in11.slice(0,3);
    	var in12 = document.getElementById('in12').value;
    	var inco12 = in12.slice(0,3); 
    	
    	// get month
    	var mon1 = document.getElementById('mon1').value;
    	var mon2 = document.getElementById('mon2').value;
    	var mon3 = document.getElementById('mon3').value;
    	var mon4 = document.getElementById('mon4').value;
    	var mon5 = document.getElementById('mon5').value;
    	var mon6 = document.getElementById('mon6').value;
    	var mon7 = document.getElementById('mon7').value;
    	var mon8 = document.getElementById('mon8').value;
    	var mon9 = document.getElementById('mon9').value;
    	var mon10 = document.getElementById('mon10').value;
    	var mon11 = document.getElementById('mon11').value;
    	var mon12 = document.getElementById('mon12').value; 
    	
    	
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
				ymax: 1000,
				gutterTop: 30,
				gutterLeft:50,
				title:'Monthly Outcome គិតជាលានរៀល',
                gutterBottom:70
            }
        }).wave({frames: 60});
    };
</script>

</body>

</html>
