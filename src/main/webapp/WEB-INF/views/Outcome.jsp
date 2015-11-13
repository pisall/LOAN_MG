
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
    <script src="${pageContext.request.contextPath}/resources/js/outcome.js"></script>
		
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

<input type ="hidden" id="out1" value=""/>
<input type ="hidden" id="out2" value=""/>
<input type ="hidden" id="out3" value=""/>
<input type ="hidden" id="out4" value=""/>
<input type ="hidden" id="out5" value=""/>
<input type ="hidden" id="out6" value=""/>
<input type ="hidden" id="out7" value=""/>
<input type ="hidden" id="out8" value=""/>
<input type ="hidden" id="out9" value=""/>
<input type ="hidden" id="out10" value=""/>
<input type ="hidden" id="out11" value=""/>
<input type ="hidden" id="out12" value=""/>







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
 
	<script>
	    window.onload = function ()
	    { 
	    	var out1 = document.getElementById('out1').value;
	    	var outco1 = out1.slice(0,3);
	    	var out2 = document.getElementById('out2').value;
	    	var outco2 = out2.slice(0,3);
	    	var out3 = document.getElementById('out3').value;
	    	var outco3 = out3.slice(0,3);
	    	var out4 = document.getElementById('out4').value;
	    	var outco4 = out4.slice(0,3);
	    	var out5 = document.getElementById('out5').value;
	    	var outco5 = out5.slice(0,3);
	    	var out6 = document.getElementById('out6').value;
	    	var outco6 = out6.slice(0,3);
	    	var out7 = document.getElementById('out7').value;
	    	var outco7 = out7.slice(0,3);
	    	var out8 = document.getElementById('out8').value;
	    	var outco8 = out8.slice(0,3);
	    	var out9 = document.getElementById('out9').value;
	    	var outco9 = out9.slice(0,3);
	    	var out10 = document.getElementById('out10').value;
	    	var outco10 = out10.slice(0,3);
	    	var out11 = document.getElementById('out11').value;
	    	var outco11 = out11.slice(0,3);
	    	var out12 = document.getElementById('out12').value;
	    	var outco12 = out12.slice(0,3);  
	    	
	    	console.log("11111111out::="+out1);
	    	console.log("2out222::="+out2);
	    	console.log("33out333333::="+out3);
	    	console.log("11111111::="+outco1);
	    	console.log("2222::="+outco2);
	    	console.log("33333333::="+outco3);
	    	
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
	    	
	    	
	        var data = [outco12,outco11,outco10,outco9,outco8,outco7,outco6,outco5,outco4,outco3,outco2,outco1];
	
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
					ymax: 1000,
					gutterTop: 30,
					gutterLeft: 50,
					title:'Monthly Outcome គិតជាលានរៀល',
	                gutterBottom:70
	            }
	        }).wave({frames: 60});
	    };
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

