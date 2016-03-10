<!DOCTYPE html>
<html lang="en">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Outcome</title> 
   <%@include file="include/_head.jsp"%>
   <%@include file="include/_script.jsp"%> 
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
		 					var out1 = dat[i].out1;
		 					var out2 = dat[i].out2; 
		 					var out3 = dat[i].out3; 
		 					var out4 = dat[i].out4; 
		 					var out5 = dat[i].out5; 
		 					var out6 = dat[i].out6; 
		 					var out7 = dat[i].out7; 
		 					var out8 = dat[i].out8; 
		 					var out9 = dat[i].out9; 
		 					var out10 = dat[i].out10; 
		 					var out11 = dat[i].out11; 
		 					var out12 = dat[i].out12; 
		 					
		 					var mon1 = dat[i].mon1;
		 					var mon2 = dat[i].mon2; 
		 					var mon3 = dat[i].mon3; 
		 					var mon4 = dat[i].mon4; 
		 					var mon5 = dat[i].mon5; 
		 					var mon6 = dat[i].mon6; 
		 					var mon7 = dat[i].mon7; 
		 					var mon8 = dat[i].mon8; 
		 					var mon9 = dat[i].mon9; 
		 					var mon10 = dat[i].mon10; 
		 					var mon11 = dat[i].mon11; 
		 					var mon12 = dat[i].mon12; 
		 					
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
								ymax: 999000000,
								gutterTop: 30,
								gutterLeft: 100,
								title:'Monthly Outcome រៀល',
				                gutterBottom:80
				            }
				        }).wave({frames: 60});
				      
		 			} 
		        
		 		});
		    });
		</script>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<%@include file="include/_fixed_up_nav.jsp"%>
			<!-- Side Bar Navigation -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<%@include file="include/_side_nav.jsp"%>
			</div>

		</nav>
		<!-- End Navigation --> 
		<div id="page-wrapper">

			<div class="container-fluid"> 
					<div class="col-lg-6" style="width:700px;height:600px;">
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
											<canvas id="cvs" width="600" height="500">[No canvas support]</canvas>
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
</body>

</html>

