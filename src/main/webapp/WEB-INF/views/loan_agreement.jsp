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

						<h2 class="page-header">Loan Agreement</h2>

					</div>

				</div>


				<div class="row" style="font-size: 12px;">

					<!-- Form User Information -->

					<div class="col-md-6 col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading" style="font-size: 14px;">User
								Information</div>
							<div class="panel-body">
								<form class="form-horizontal" action="LoanAgreementController" method ="POST" role="form">

									<div>
										<span class="glyphicon glyphicon-user"
											style="font-size: 90px;"></span>
									</div>
									<span class="btn btn-default btn-file btn-sm"> Browse 
									<input type="file" id="cu_photo" name="cu_photo">
										
									</span>

									<div class="form-group">
										<label class="control-label col-sm-2" for="fst_nm">
											Name:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_nm" id="cu_nm"
												placeholder="Full Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Nickname:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_nick_nm" id="nick_name"
												placeholder="Nick Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">Sex</label>
										<div class="col-sm-10" name="cu_sex" id="cu_sex">
											<label class="radio-inline"> 
												<input type="radio"  name="optradio" checked="checked">Male
											</label>
											 <label class="radio-inline"> 
												<input type="radio" name="optradio">Female
											</label> 
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											DOB</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_dob" id="cu_dob"
												placeholder="use date of birth">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_national_id" id="cu_id_card"
												placeholder="Enter National Card">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											Phone</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="cu_phone" id="cu_phone"
												placeholder="User Phone number">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Address</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="6.5" name="cu_address" id="cu_address" placeholder="User Address"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Pawn</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="7" name="cu_pawn" id="user_pawn" placeholder="User Pawn"></textarea>
										</div>
									</div>

									

								</form>
							</div>
						</div>
					</div>

					<!-- Loan Information -->

					<div class="col-md-6 col-lg-6">
						<div class="panel panel-default">
							<div class="panel-heading" style="font-size: 14px;">Loan
								Information</div>
							<div class="panel-body">
								<form class="form-horizontal" role="form">
										
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Guarantor</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="gu_nm" id="gu_name"
												placeholder="Guarantor name">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Guarantor</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="gu_nick_nm" id="gu_nick_nm"
												placeholder="Guarantor nick name">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="" id="gu_sex"
												placeholder="Guarantor sex">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="" id="gu_dob"
												placeholder="Guarantor dob">
										</div>
									</div> 
									<div class="form-group">
										<label class="control-label col-sm-2" for="nt_card">
											ID Card</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"  name="gu_national_id" id="gu_id_card"
												placeholder="Guarantor National Card">
										</div>
									</div>
										<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="gu_phone" id="gu_phone"
												placeholder="Guarantor phone">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="gu_address" id="gu_address"
												placeholder="Guarantor address">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="gu_dtt" id="gu_dtt"
												placeholder="Guarantor Date Time">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Sex</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="photo" id="photo"
												placeholder="Guarantor photo">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="text">
											Note</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="3" name="gu_note" id="gu_note" placeholder="Guarantor Note"></textarea>
										</div>
									</div>
									<hr /> 
									<!-- account infor  -->
									<div class="form-group">
										<label class="control-label col-sm-2">Amount</label>
										<div class="col-sm-10">
											<div class="input-group">
												<input type="text" class="form-control" name="ac_amount" id="amount"
													placeholder="Amount">
												<div class="input-group-addon">R</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">Rate</label>
										<div class="col-sm-10">
											<div class="input-group">
												<input type="text" class="form-control" name="ac_rate" id="rate"
													placeholder="Rate">
												<div class="input-group-addon">%</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Type:</label>
										<div class="col-sm-10">
											<select class="form-control">
												<option>Day</option>
												<option>Week</option>
												<option>Month</option>
												<option>Year</option>
											</select>
										</div>
									</div>


									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Period:</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="ls_nm"
												placeholder="Last Name" style="width: 80%; float: left">
											<select class="form-control" style="width: 20%">
												<option>Day</option>
												<option>Week</option>
												<option>Month</option>
												<option>Year</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm">
											Start Date:</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="ls_nm"
												placeholder="Last Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="ls_nm"> End
											Date:</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="ls_nm"
												placeholder="Last Name">
										</div>
									</div>

									<div class="pull-right">
										<button type="submit" class="btn btn-primary">Register</button>
										<button type="button" class="btn btn-default">Cancel</button>
									</div>


								</form>
							</div>
						</div>
					</div>


				</div>
				<!-- //list -->


			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<%@include file="include/_script.jsp"%>

</body>

</html>
