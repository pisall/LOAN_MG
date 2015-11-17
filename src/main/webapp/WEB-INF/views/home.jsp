<%@include file="include/_head.jsp"%>

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
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">								
									Customer Officer Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-primary">
									<div class="panel-heading" id="customer_officer_info" style="cursor: pointer;">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Co_Info.png" height="150" width="250">
											
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">
													<c:if test="${not empty totalCo}">
														<c:out value="${totalCo}"/>
													</c:if>
												</div>
											</div>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title"> 								
									Customer Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-green">
									<div class="panel-heading" id="customer_info" style="cursor: pointer;">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Customers.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge">
													<c:if test="${not empty totalCu}">
														<c:out value="${totalCu}"/>
													</c:if>
												</div>
												
											</div>
										</div>
									</div>
								
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"> -->
									</i>Income Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-yellow">
									<div class="panel-heading" id="income_chart" style="cursor: pointer;">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Income.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge"></div>
												
											</div>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<!-- <i class="fa fa-money fa-fw"></i> -->
									Outcome Information
								</h3>
							</div>
							<div class="panel-body">
								<div class="panel panel-red">
									<div class="panel-heading" id="outcome_chart" style="cursor: pointer;">
										<div class="row">
											<div class="col-xs-3">
												<img src="${pageContext.request.contextPath}/resources/img/Outcome1.png" height="150" width="250">
											</div>
											<div class="col-xs-9 text-right">
												<div class="huge"></div>
												
											</div>
										</div>
									</div>
								
								</div>
							</div>
						</div>
					</div>


				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>
	<script type="text/javascript">
			$(function(){  
				$("#customer_officer_info").click(function(){
				
					location.href="${pageContext.request.contextPath}/co_001_controller/co_0003";
				});
				$("#customer_info").click(function(){
					location.href="${pageContext.request.contextPath}/customer/home_customer";
				});
				$("#income_chart").click(function(){					
					location.href="${pageContext.request.contextPath}/Income/IncomeView";
				});
				$("#outcome_chart").click(function(){					
					location.href="${pageContext.request.contextPath}/Outcome/OutcomeView";
				});
			})
			
	</script>
	
</body>

</html>

