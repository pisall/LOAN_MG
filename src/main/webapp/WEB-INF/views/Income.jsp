
<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Income</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
      
      
      <!-- RGraph Libraries -->
   <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.common.core.js"></script>  
   <script src="${pageContext.request.contextPath}/resources/libraries/RGraph.bar.js"></script>
   
</head>

<body>
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

				 
				 
					<div class="col-lg-6" style="width:589px;height:320px;">
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
	<script>
    window.onload = function ()
    { 
        var data = [40,80,60,30,50,20,60,80,40,50,70,10];

        var bar = new RGraph.Bar({
            id: 'cvs',
            data: data,
            options: {
                backgroundGridAutofitNumvlines: 0,
                linewidth: 0,
                shadow: false,
                hmargin: 6,
                colors: ['Gradient(blue:blue:green)', 'Gradient(green:#0f0)'],
                labels: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
                clearto: 'white',
                variant: '3d',
				ymin:0,
				ymax: 100,
				gutterTop: 30,
				gutterLeft: 30,
				title:'Monthly Outcome គិតជាលានរៀល',
                gutterBottom: 90
            }
        }).wave({frames: 60});
    };
</script>
	<%@include file="include/_script.jsp"%> 
</body>

</html>

