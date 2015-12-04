<%@include file="include/_head.jsp"%>
	<%
		if(strCoNm=="" || strCoNm==null){
 			response.sendRedirect("../login");
 		}
	%>
<body>

	<input type="hidden" value="${TOTAL_AMOUNT_LATE}" id="total">
	<input type="hidden" value="${PERIOD_TYPE}" id="PERIOD_TYPE">

	
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
							<button style="float: left;" class="btn btn-primary"
								onclick=" return goBackPage();">
								<span style="width: 30px" class="glyphicon glyphicon-arrow-left"></span>
							</button> 
						<h2 class="page-header" style="text-align: center">Loan
							Approval</h2>
							 
					</div>
				</div>

				<div class="row" style="font-size:12px">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<div class="panel panel-default">
							<div class="panel-heading"><b>Customer Officer Information</b></div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped table-responsive">
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
							<div class="panel-heading"><b>Customer Information</b></div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped table-responsive">
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
							<div class="panel-heading"><b>Gurantor Information</b></div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped table-responsive">
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
							<div class="panel-heading"><b>Loan Information</b></div>
							<div class="panel-body" style="padding:10px">
								<div >
									<table class="table table-hover table-striped table-responsive">
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
											<input  type="text" class="form-control check_number required"
												name="paid_amount" id="paid_amount" placeholder="0.0" disabled="disabled">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine">Amount
											fine:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control check_number required "
												name="amount_fine" value="0" id="amount_fine" placeholder="0.0">											
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="amount-fine">Days
											Late:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control "
												name="day_late" id="day_late" placeholder="0.0" disabled="disabled">											
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="tr_type">Transection
											Type:</label>
										<div class="col-sm-8">
											<select class="form-control" id="tr_type" name="tr_type">
												<option value="2">Complete</option>											
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
					
					
						<div style="float: left;margin-left: 18px;"><b>Approved by</b><br/><br/><span id="admin_app_date"></span><br/><br/>Account
							<br/><br/><br/><br/>
							<span>Name :......................................... </span>
						</div>
						
						<div style="float: right;margin-right: 162px">
						<b>Client's Fingerprint</b><br/><br/><span id="client_app_date"></span><br/><br/>
							<br/><br/><br/><br/>
							<span id="cu_name"></span>
						</div>
						
					</div>
					
					
				</div>
			</div>

			<!-- //list -->


		</div>
		<!-- /.container-fluid -->

	<!-- /#page-wrapper -->
	<%@include file="include/_script.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/js/loan_approval.js"></script>
	<script type="text/javascript">
		var BASE_URL = "${pageContext.request.contextPath}";
	</script>

</body>

</html>
