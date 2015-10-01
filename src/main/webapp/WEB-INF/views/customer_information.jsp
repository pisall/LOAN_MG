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

				<!-- Page Heading -->
				<div class="row">

					<div class="col-lg-12">

						<h2 class="page-header">
							<span></span>Customer Infomation
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
										<span class="col-md-4 col-sm-4" style="padding: 0px"> <select
											class="form-control">
												<option>Co ID or Name</option>
												<option>Co ID</option>
												<option>Name</option>
										</select>
										</span>

									</div>
									<div class="col-md-6 col-sm-6 pull-right">

										<div class="form-group input-group">
											<input class="form-control" type="text"
												placeholder="Enter Customer ID Card or Name"> <span
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
											<tr>
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
							<div class="col-md-1">
								<select class="form-control" id="record_num" style='width:100%'>
									<option value="5">05</option>
									<option  value="10">10</option>
									<option  value="20">20</option>
									<option  value="30">30</option>
									<option  value="40">40</option>
									<option  value="50">50</option>
								</select>
							</div>
							<div class="col-md-11" style="text-align: center;">
								<!-- <div class="col-md-6 col-md-offset-3" style="text-align: center"> -->
									<ul class="pagination" id="paging" style="margin:0 auto;">
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
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/js/customer_information.js"></script>

</body>

</html>
