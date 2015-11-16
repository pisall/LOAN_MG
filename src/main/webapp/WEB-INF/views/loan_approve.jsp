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
				<div class="row" >
					<div class="col-lg-12 head-print">
						<input type="hidden" id="tr_id"
							value="<%=request.getParameter("tr_id")%>" /> <input
							type="hidden" id="cu_id"
							value="<%=request.getParameter("cu_id")%>" />
						<h2 class="page-header" style="text-align: center">Loan
							Approval</h2>
					</div>
				</div>

				<div class="row" style="font-size:12px">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<div class="panel panel-default">
							<div class="panel-heading">Customer Officer Information</div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped">
										<thead class="style2">
											<tr class="active">
												<th>Name</th>										
												<th>Phone</th>
												<th>NIN</th>
											</tr>
										</thead>
										<tbody id="co_info">
											
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<div class="panel panel-default">
							<div class="panel-heading">Customer Information</div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped">
										<thead class="style2">
											<tr class="active">
												<th>Name</th>												
												<th>Phone</th>
												<th>NIN</th>
											</tr>
										</thead>
										<tbody id="cu_info">
											
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>
						<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
				
						<div class="panel panel-default">
							<div class="panel-heading">Gurantor Information</div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped">
										<thead class="style2">
											<tr class="active">
												<th>Name</th>											
												<th>Phone</th>
												<th>NIN</th>
											</tr>
										</thead>
										<tbody id="gu_info">
											
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">Loan Information</div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped">
										<thead class="style2">
											<tr class="active">
												<th>Pay Type</th>
												<th>Total</th>
												<th>Date</th>
												<th>Pay Amount</th>
												<th>Balance</th>
												<th>Pawn</th>
											</tr>
										</thead>
										<tbody id="loan_info">
											<tr>
												<td>Day</td>
												<td>9000</td>
												<td>903;/334/4</td>
												<td>3543</td>
												<td>43432</td>
												<td>fdsf</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<form class="form-horizontal" id="form_approve">
						<div class="col-lg-12">

							<div class="row">
								<div class="col-lg-6 col-md-6">
									<div class="form-group">

										<label class="control-label col-sm-4" for="paid_amount">
											Paid Amount:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control check_number required"
												name="paid_amount" id="paid_amount" placeholder="0.0">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine">Amount
											fine:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control check_number required"
												name="amount_fine" id="amount_fine" placeholder="0.0">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="tr_type">Transection
											Type:</label>
										<div class="col-sm-8">
											<select class="form-control" id="tr_type" name="tr_type">
												<option value="2">Complete</option>
												<option value="3">Area</option>
												<option value="4">Finished</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="form-group">
										<label class="control-label col-sm-4" for="note">Note:</label>
										<div class="col-sm-8">
											<textarea class="form-control" id="tr_note" name="note"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="email"></label>
										<div class="col-sm-8">
											<button type="button" id="btnApprovale"
												class="btn btn-primary btn-block">Approve</button>
										</div>
									</div>

								</div>
							</div>
						</div>
					</form>
					</div>
					
				</div>
			</div>

			<!-- //list -->


		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->
	<%@include file="include/_script.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/js/loan_approval.js"></script>
	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
	</script>

</body>

</html>
