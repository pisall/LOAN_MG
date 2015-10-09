<%@include file="include/_head.jsp"%>

<%
	HttpSession ses = request.getSession(false);
	ses.setAttribute("id", "9");
	ses.setAttribute("brand", "bb");
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

				<!-- Page Heading -->
				<div class="row">

					<div class="col-lg-12 col-md-12 col-sm-12">

						<h2 class="page-header">

							<span></span>Customer Infomation
							<!-- <button style="float: right;" type="button" class="btn btn-info" data-toggle="modal"
							data-target="#myModal">Add Customer</button> -->
						</h2>

					</div>
				</div>
				<!--//Page Heading -->
				<!-- list-->
				<div class="row">
					<div class="col-md-12 col-lg-12">
						<!-- panel top-->
						<div class="panel panel-default">
							<div class="panel panel-heading">
								<div class="row">
									<div class="col-md-6">
										<span class="col-md-8 col-sm-8" style="padding: 0px"> <select
											class="form-control" id="co_info">

										</select>
										</span>

									</div>
									<div class="col-md-6 col-sm-6 pull-right">

										<div class="form-group input-group">
											<input class="form-control" type="text" id="word"
												placeholder="Search Customer By ID Card or Name"> <span
												class="input-group-btn"><button
													class="btn btn-default" type="button">
													<i class="fa fa-search"></i>
												</button></span>
										</div>

									</div>
								</div>

							</div>
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead>
											<tr class="active">
												<th>ID</th>
												<th>Name</th>
												<th>Sex</th>
												<th>DOF</th>
												<th>National ID</th>
												<th>Address</th>
												<th>Phone</th>

												<th>Action</th>
											</tr>
										</thead>
										<tbody id="tableCustomer">


										</tbody>
									</table>
								</div>

							</div>
							<!-- //panel body -->

						</div>


						<!--//panel top -->

					</div>

				</div>
				<!-- //list -->
				<div class="row">
					<div class="col-md-1" id="select_num">
						<select class='form-control' id='record_num' style='width: 100%'>
						<option value='10'>10</option>
						<option value='20'>20</option>
						<option value='30'>30</option>
						<option value='40'>40</option>
						<option value='50'>50</option>
						</select>
					</div>
					<div class="col-md-11" style="text-align: center;">
						<!-- <div class="col-md-6 col-md-offset-3" style="text-align: center"> -->
						<ul class="pagination" id="paging" style="margin: 0 auto;">
						</ul>
						<!-- </div> -->
					</div>

				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>

	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var id="<%=ses.getAttribute("id")%>";
		var brand="<%=ses.getAttribute("brand")%>";
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/js/customer.js"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/customer_officer.js"></script>

</body>

</html>
