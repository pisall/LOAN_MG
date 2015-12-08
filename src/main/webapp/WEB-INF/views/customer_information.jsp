
<%@include file="include/_head.jsp"%>
	<%
		if(strCoNm=="" || strCoNm==null){
 			response.sendRedirect("../login");
 		}
	%>
<body>

	<div id="wrapper">
	
	

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">		
			
			<!-- Fixed Up Navigation -->
			<%@include file="include/_fixed_up_nav.jsp"%>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<%@include file="include/_side_nav.jsp"%>
			</div>

		</nav>
		<!-- End Navigation -->

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">

					<div class="col-lg-10 col-md-10 col-sm-10">
						<h2 class="page-header">

							<span>Customer Infomation</span> <span> </span>
						</h2>
					</div>
					<div class="col-lg-2 col-md-2 col-sm-2">
						<button id="btnAdSearch"  class="btn btn-primary page-header" value="1">Show Advance Search</button>
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
									<div class="col-md-6 col-sm-6">
										<select class="form-control" id="co_info">
											<option value="">Display All</option>
										</select>
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
								<div class="row" id="advance_search" style="display: none;">		
									<div class="col-md-4 col-sm-4">
										<select class="form-control" id="tr_type">
											<option value="1">All</option>
											<option value="0">Pay Today</option>
											<option value="3">Area</option>
											<option value="2">Complete</option>
											<option value="4">Finish</option>
										</select>
									</div>			
									<div class="col-md-4 col-sm-4">									
										<input class="form-control" type="text" id="from" name="from" placeholder="Start date">											
									</div>									
									<div class="col-md-4 col-sm-4">									
										<input class="form-control" disabled="disabled" type="text" id="to" name="to" placeholder="End date">										
									</div>										
								</div>

							</div>
							<!-- panel body -->
							<div class="panel panel-body">
								<div class="table-responsive">
									<table class="table table-hover table-striped">
										<thead class="style2">
											<tr class="active">
												<th>ID</th>
												<th style="width: 12%">Name</th>
												<th>Nickname</th>
												<th>Sex</th>
												<th>Phone</th>
												<th style="width: 45%">Address</th>
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
							<option value='15'>15</option>
							<option value='20'>20</option>
							<option value='25'>25</option>
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
		<!-- <label for="from" class="label-control">From</label> <input class="form-control" type="text" id="from"
			name="from"> <label class="form-control" for="to">to</label> <input class="form-control" type="text"
			id="to" name="to"> -->
	</div>
	
	<!-- /#wrapper -->
	<%@include file="customer_detail.jsp"%>

	<%@include file="include/_script.jsp"%>

	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
		var id="<%=strCoId%>";
		var PAGE_ID="${page_id}";
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/js/customer.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/customer_officer.js"></script>

	
</body>

</html>
